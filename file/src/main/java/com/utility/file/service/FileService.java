package com.utility.file.service;


import com.utility.file.model.FileRequest;
import com.utility.file.model.FileResponse;

public interface FileService {
    
    FileResponse uploadFile(FileRequest request);

    FileResponse getSignedUrl(FileRequest request);

    FileResponse download(FileRequest request);
}
