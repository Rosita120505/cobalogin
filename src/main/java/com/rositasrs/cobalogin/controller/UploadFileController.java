package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.entity.UploadFile;
import com.rositasrs.cobalogin.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/upload")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/local")
    public void uploadLocal (@RequestParam("file")MultipartFile multipartFile) {
        uploadFileService.uploadToLocal(multipartFile);
        uploadFileService.uploadToDb(multipartFile);
    }


    @PostMapping("/db")
    public void uploadDb (@RequestParam("file")MultipartFile file) {
        uploadFileService.uploadToDb(file);
    }

    @GetMapping("/download/{id}")
    public Optional<UploadFile> downloadFile (@PathVariable String id) {
        return uploadFileService.downloadFile(id);
    }
}
