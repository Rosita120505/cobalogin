package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.service.FileUploadUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadUserController {
@Autowired
FileUploadUserService fileUploadUserService;

    @PostMapping
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        fileUploadUserService.uploadFile(file);

    }
}
