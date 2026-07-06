package com.utility.firebase.cloud;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FirebaseStorage {

    private final Storage storage;
    private final String bucketName;

    public FirebaseStorage(String serviceAccountPath, String bucketName) {
        this.bucketName = bucketName;
        try {
            FileInputStream serviceAccount = new FileInputStream(serviceAccountPath);
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void upload(MultipartFile multipartFile, String filePath, String fileName) {
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, filePath + fileName).setContentType(multipartFile.getContentType()).build();
        try {
            storage.create(blobInfo, multipartFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadFile(byte[] fileBytes, String storageFilePath, Map<String, String> metaData) {
        BlobId blobId = BlobId.of(bucketName, storageFilePath);
        BlobInfo.Builder builder = BlobInfo.newBuilder(blobId);
        if (!ObjectUtils.isEmpty(metaData)) {
            builder.setMetadata(metaData);
        }
        storage.create(builder.build(), fileBytes);
    }

    public void download(String remoteFilePath, String fileName, String downloadFilePath) {
        BlobId blobId = BlobId.of(bucketName, remoteFilePath + fileName);
        Blob blob = storage.get(blobId);
        if (blob == null) {
            throw new RuntimeException("File Not Found");
        }
        blob.downloadTo(Paths.get(downloadFilePath));
    }

    public void delete(String storageFilePath) {
        BlobId blobId = BlobId.of(bucketName, storageFilePath);
        storage.delete(blobId);
    }


    public String getSignUrl(String filePath, String fileName, long expirationTime) {
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, filePath + fileName).build();
        URL url = storage.signUrl(blobInfo, expirationTime, TimeUnit.SECONDS);
        return url.toExternalForm();
    }

    public Map<String, Map<String, String>> bucketFiles() {
        var map = new HashMap<String, Map<String, String>>();
        Page<Blob> blobs = storage.list(bucketName);
        for (Blob blob : blobs.iterateAll()) {
            map.put(blob.getName(), blob.asBlobInfo().getMetadata());
        }
        return map;
    }
}