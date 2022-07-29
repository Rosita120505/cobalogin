package com.rositasrs.cobalogin.service;

import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface ProductService {

    public void uploadFileLocal(MultipartFile file) throws IOException;
    public Product uploadFileDb(MultipartFile file) throws IOException;

    Optional<Product> downloadFile(String productId);
}
