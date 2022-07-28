package com.rositasrs.cobalogin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {

    public void uploadFileLocal(MultipartFile file) throws IOException;
    public void uploadFileDb(MultipartFile file) throws IOException;
}
