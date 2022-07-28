package com.rositasrs.cobalogin.service;

import com.rositasrs.cobalogin.model.entity.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface UploadFileService {

    public void uploadToLocal(MultipartFile file);
    public void uploadToDb(MultipartFile file);
    public Optional<UploadFile> downloadFile (String fileId);
}
