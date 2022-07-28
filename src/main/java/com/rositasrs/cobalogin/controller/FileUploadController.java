package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/unduh")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/pc")
    public void uploadToPc (@RequestParam("file")MultipartFile file) throws IOException {
        fileUploadService.uploadToPc(file);

    }
    @PostMapping("/database")
    public void uploadToDatabase(@RequestParam("file")MultipartFile file){
        fileUploadService.uploadToDatabase(file);
    }
}
