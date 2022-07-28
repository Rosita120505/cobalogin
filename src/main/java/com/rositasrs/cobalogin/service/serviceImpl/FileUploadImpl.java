package com.rositasrs.cobalogin.service.serviceImpl;

import com.rositasrs.cobalogin.model.entity.FileUpload;
import com.rositasrs.cobalogin.repository.FileUploadRepository;
import com.rositasrs.cobalogin.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadImpl implements FileUploadService {

    private String folderPath = "C:\\fileUpload\\";

    @Autowired
    public FileUploadRepository fileUploadRepository;

    @Override
    public void uploadToPc(MultipartFile file) {
        try{
            byte[] data = file.getBytes();
            Path path = Paths.get(folderPath+file.getOriginalFilename()) ;
            Files.write(path,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadToDatabase(MultipartFile file) {
        FileUpload fileUpload = new FileUpload();
        try {
            fileUpload.setDataFile(file.getBytes());
            fileUpload.setFileType(file.getContentType());
            fileUpload.setFileName(file.getOriginalFilename());
            fileUploadRepository.save(fileUpload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
