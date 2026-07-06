package com.utility.file.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRequest {
    private String name;
    private String path;
    private MultipartFile file;
    private String downloadFilePath;
    private long expirationTime;
}
