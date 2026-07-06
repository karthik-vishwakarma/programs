package com.utility.firebase.cloud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirebaseStorageSync {

    private FirebaseStorage firebaseStorage;

    private String localDirectory;

    public FirebaseStorageSync(String localDirectory, String serviceAccountPath, String bucketName) {
        this.localDirectory = localDirectory;
        this.firebaseStorage = new FirebaseStorage(serviceAccountPath, bucketName);
    }

    public Map<String, List<String>> storageSync() {
        try {
            // List files in Firebase Storage bucket
            Map<String, Map<String, String>> fireBasePathMetaMap = firebaseStorage.bucketFiles();

            // Map of path and modification time files in local directory
            Map<String, String> pathTimeMap = localFiles(localDirectory);

            List<String> uploaded = new ArrayList<>();
            List<String> modified = new ArrayList<>();
            // Upload files to Firebase Storage if they don't exist there or modified
            pathTimeMap.forEach((path, modificationTime) -> {
                boolean fileExist = fireBasePathMetaMap.containsKey(path);
                if (!fileExist || !modificationTime.equals(fireBasePathMetaMap.get(path).get("modificationTime"))) {
                    byte[] fileBytes;
                    try {
                        fileBytes = Files.readAllBytes(Paths.get(localDirectory + path));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    firebaseStorage.uploadFile(fileBytes, path, Map.of("modificationTime", modificationTime));
                    if (fileExist) {
                        modified.add(path);
                    } else {
                        uploaded.add(path);
                    }
                }
            });
            List<String> removed = new ArrayList<>();
            // delete files from Firebase Storage if they don't exist locally
            fireBasePathMetaMap.forEach((path, modificationTime) -> {
                if (!pathTimeMap.containsKey(path)) {
                    firebaseStorage.delete(path);
                    removed.add(path);
                }
            });

            return Map.of("added", uploaded, "modified", modified, "removed", removed);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }


    private Map<String, String> localFiles(String localDirectory) throws IOException {
        try (Stream<Path> pathStream = Files.walk(Paths.get(localDirectory))) {
            return pathStream.filter(Files::isRegularFile).collect(Collectors.toMap(path -> {
                String absolutePath = path.toAbsolutePath().toString();
                return absolutePath.substring(localDirectory.length());
            }, path -> String.valueOf(path.toFile().lastModified())));
        }
    }
}