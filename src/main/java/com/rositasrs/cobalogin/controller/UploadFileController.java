package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/local")
    public void uploadLocal (@RequestParam("file")MultipartFile multipartFile) {
        uploadFileService.uploadToLocal(multipartFile);
    }

    @PostMapping("/db")
    public void uploadDb (@RequestParam("file")MultipartFile file) {
        uploadFileService.uploadToDb(file);
    }
}
