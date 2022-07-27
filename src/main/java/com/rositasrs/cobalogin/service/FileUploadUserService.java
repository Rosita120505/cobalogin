package com.rositasrs.cobalogin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadUserService {

    public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {
        file.transferTo(new File("C:\\Users\\psm\\Documents\\Ridwan Maulana\\"+file.getOriginalFilename()));
    }
}
