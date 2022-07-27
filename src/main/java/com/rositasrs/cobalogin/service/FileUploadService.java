package com.rositasrs.cobalogin.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public void UploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\fileUpload\\"+file.getOriginalFilename()));

    }
}
