package com.rositasrs.cobalogin.service.serviceImpl;

import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.ProductRepository;
import com.rositasrs.cobalogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ProductServiceImpl implements ProductService {

  private String fileUploadPath = "D:\\";
  @Autowired
  private ProductRepository productRepository;
  @Override
  public void uploadFileLocal(MultipartFile file) throws IOException {

    byte[] data = file.getBytes();
    Path path = Paths.get(fileUploadPath + file.getOriginalFilename());
    Files.write(path, data);


  }

  @Override
  public void uploadFileDb(MultipartFile file) throws IOException {

    Product product = new Product();
    product.setFileData(file.getBytes());
    product.setFileName(file.getOriginalFilename());
    product.setFileType(file.getContentType());
    productRepository.save(product);


  }
}
