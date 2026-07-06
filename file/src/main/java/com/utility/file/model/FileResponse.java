package com.utility.file.model;


import lombok.Data;

@Data
public class FileResponse {
    private String name;
    private String signedUrl;
    private boolean generateSignedUrl;
}
