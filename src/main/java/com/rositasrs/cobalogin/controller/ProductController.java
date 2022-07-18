package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductRepository productRepository;

  public ProductController(ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  @GetMapping("/all")
  public List<ProductDto> getListProduct(){
    List<ProductDto> list = new ArrayList<>();
    for(Product p :productRepository.findAll()){
      list.add(convertEntitytoDto(p));
    }
    return list;
  }

  @PostMapping("/save")
  public DefaultResponse<ProductDto> saveProduct(@RequestBody ProductDto productDto){
    Product product = convertDtoToEntity(productDto);
    DefaultResponse<ProductDto> response = new DefaultResponse<>();
    Optional<Product> optionalProduct = productRepository.findByProductId(productDto.getProductId());
    if(optionalProduct.isPresent()){
      response.setMessage("Gagal Menyimpan, Produk Telah Tersedia");
    } else{
      productRepository.save(product);
      response.setMessage("Produk Berhasil Disimpan");
      /*response.setData(productDto);*/
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
    product.setDescription(dto.getDescription());
    product.setProductWeight(dto.getProductWeight());
    product.setProductReleaseDate(dto.getProductReleaseDate());

    return product;
  }

  public ProductDto convertEntitytoDto(Product entity){
    ProductDto dto = new ProductDto();
    dto.setProductId(entity.getProductId());
    dto.setProductName(entity.getProductName());
    dto.setColorId(entity.getColorId());
    dto.setProductStock(entity.getProductStock());
    dto.setPrice(entity.getPrice());
    dto.setDescription(entity.getDescription());
    dto.setProductWeight(entity.getProductWeight());
    dto.setProductReleaseDate(entity.getProductReleaseDate());

    return dto;
  }
}
