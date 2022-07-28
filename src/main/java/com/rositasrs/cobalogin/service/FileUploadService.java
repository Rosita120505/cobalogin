package com.rositasrs.cobalogin.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public interface FileUploadService {

    void uploadToPc(MultipartFile file);

    void uploadToDatabase(MultipartFile file);
}
