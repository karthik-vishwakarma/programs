package com.utility.file.service.impl;

import com.utility.file.model.FileRequest;
import com.utility.file.model.FileResponse;
import com.utility.file.service.FileService;
import com.utility.firebase.cloud.FirebaseStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Service
public class FileServiceImpl implements FileService {

    @Value("${firebase.service.account.file}")
    private String serviceAccountPath;

    @Value("${firebase.bucket.name}")
    private String bucketName;

    private FirebaseStorage firebaseStorage;

    @PostConstruct
    void loadFirebaseStorage() {
        this.firebaseStorage = new FirebaseStorage(serviceAccountPath, bucketName);
    }

    @Override
    public FileResponse uploadFile(FileRequest request) {
        firebaseStorage.upload(request.getFile(), request.getPath(), request.getName());
        return new FileResponse();
    }

    @Override
    public FileResponse getSignedUrl(FileRequest request) {
        String signUrl = firebaseStorage.getSignUrl(request.getPath(), request.getName(), request.getExpirationTime());
        FileResponse fileResponse = new FileResponse();
        fileResponse.setSignedUrl(signUrl);
        fileResponse.setName(request.getName());
        return fileResponse;
    }

    @Override
    public FileResponse download(FileRequest request) {
        firebaseStorage.download(request.getPath(), request.getName(), request.getDownloadFilePath());
        FileResponse fileResponse = new FileResponse();
        fileResponse.setName(request.getName());
        return fileResponse;
    }
}