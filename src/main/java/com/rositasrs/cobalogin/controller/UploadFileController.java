package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.entity.UploadFile;
import com.rositasrs.cobalogin.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Resource> downloadFile (@PathVariable String id) {

        Optional<UploadFile> uploadFileToRet = uploadFileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploadFileToRet.get().getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = "+uploadFileToRet.get().getFileName())
                .body(new ByteArrayResource(uploadFileToRet.get().getFileData()));
    }
}
