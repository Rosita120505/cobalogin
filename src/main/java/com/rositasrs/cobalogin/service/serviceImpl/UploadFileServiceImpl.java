package com.rositasrs.cobalogin.service.serviceImpl;

import com.rositasrs.cobalogin.model.entity.UploadFile;
import com.rositasrs.cobalogin.repository.UploadFileRepository;
import com.rositasrs.cobalogin.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    private String uploadFolderPath = "C:\\Users\\psm\\Documents\\Ridwan Maulana\\";

    @Autowired
    public UploadFileRepository uploadFileRepository;

    @Override
    public void uploadToLocal(MultipartFile file) {
        try{
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath+file.getOriginalFilename()) ;
            Files.write(path,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadToDb(MultipartFile file) {
        UploadFile uploadFile = new UploadFile();
        try {
            uploadFile.setFileData(file.getBytes());
            uploadFile.setFileType(file.getContentType());
            uploadFile.setFileName(file.getOriginalFilename());
            uploadFileRepository.save(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<UploadFile> downloadFile(String fileId) {
        Optional<UploadFile> uploadFileToRet = uploadFileRepository.findById(fileId);
        return uploadFileToRet;
    }
}
