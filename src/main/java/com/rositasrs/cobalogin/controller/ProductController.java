package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.LoginDto;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.model.entity.User;
import com.rositasrs.cobalogin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/type/{productType}") // buat ngefilter sesuai tipe produk
  public DefaultResponse getByProductType(@PathVariable String productType){
    DefaultResponse df = new DefaultResponse();
    Optional<Product> productOptional = productRepository.findByProductType(productType);
    if(productOptional.isPresent()){
      df.setStatus(Boolean.TRUE);
      df.setData(convertEntitytoDto(productOptional.get()));
      df.setMessage("Tipe Produk Ditemukan");
    } else {
      df.setStatus(Boolean.FALSE);
      df.setMessage("Tipe Produk Tidak Ditemukan");
    }
    return df;
  }

  @GetMapping("/all") // buat nampilin produk yang ada di database
  public List<ProductDto> getListProduct(){
    List<ProductDto> list = new ArrayList<>();
    for(Product p :productRepository.findAll()){
      list.add(convertEntitytoDto(p));
    }
    return list;
  }

  @PostMapping("/save") // buat nyimpen produk di database
  public DefaultResponse<ProductDto> saveProduct(@RequestBody ProductDto productDto){
    Product product = convertDtoToEntity(productDto);
    DefaultResponse<ProductDto> response = new DefaultResponse<>();
    Optional<Product> optionalProduct = productRepository.findByProductId(productDto.getProductId());
    if(optionalProduct.isPresent()){
      response.setStatus(Boolean.FALSE);
      response.setMessage("Gagal Menyimpan, Produk Telah Tersedia");
    } else{
      productRepository.save(product);
      response.setStatus(Boolean.TRUE);
      response.setMessage("Produk Berhasil Disimpan");
      response.setData(productDto);
    }
    return response;
  }

  public Product convertDtoToEntity(ProductDto dto){
    Product product = new Product();
    product.setProductId(dto.getProductId());
    product.setProductName(dto.getProductName());
    product.setColorId(dto.getColorId());
    product.setProductStock(dto.getProductStock());
    product.setPrice(dto.getPrice());
    product.setProductDescription(dto.getProductDescription());
    product.setProductWeight(dto.getProductWeight());
    product.setProductReleaseDate(dto.getProductReleaseDate());
    product.setProductStockFinal(dto.getProductStockFinal());
    product.setProductType(dto.getProductType());

    return product;
  }

  public ProductDto convertEntitytoDto(Product entity){
    ProductDto dto = new ProductDto();
    dto.setProductId(entity.getProductId());
    dto.setProductName(entity.getProductName());
    dto.setColorId(entity.getColorId());
    dto.setProductStock(entity.getProductStock());
    dto.setPrice(entity.getPrice());
    dto.setProductDescription(entity.getProductDescription());
    dto.setProductWeight(entity.getProductWeight());
    dto.setProductReleaseDate(entity.getProductReleaseDate());
    dto.setProductStockFinal(entity.getProductStockFinal());
    dto.setProductType(entity.getProductType());

    return dto;
  }
}
