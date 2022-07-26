package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.dto.projection.BestSellerDto;
import com.rositasrs.cobalogin.model.entity.Product;
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

  @GetMapping("/all") // buat nampilin produk yang ada di database
  public DefaultResponse getListAllProduct() {
    DefaultResponse df= new DefaultResponse();
    List<ProductDto> list = new ArrayList<>();
    List<Product> lists = productRepository.findAll();
    if(lists.size() != 0) {
      for (Product p : lists) {
        df.setMessage("Berikut adalah list semua produk");
        list.add(convertEntitytoDto(p));
      }
      df.setData(list);
    }
    return df;
  }

  @GetMapping("/type/{productType}") // buat filter sesuai tipe produk
  public DefaultResponse findAllByProductType(@PathVariable String productType) {
    DefaultResponse df = new DefaultResponse();
    List<ProductDto> list = new ArrayList<>();
    List<Product> lists = productRepository.findAllByProductType(productType);
    if (lists.size() == 0) {
      df.setMessage("Tipe Produk Tidak Ditemukan");
    } else {
      df.setMessage("Berikut Adalah Daftar Produk Sesuai Tipe");
      for (Product p : lists) {
        list.add(convertEntitytoDto(p));
      }
      df.setData(list);
    }
    return df;
  }

  @GetMapping("/id/{productId}") // buat filter sesuai tipe produk tapi cuma satu
  public DefaultResponse getByProductId(@PathVariable Integer productId) {
    DefaultResponse df = new DefaultResponse();
    Optional<Product> productOptional = productRepository.findByProductId(productId);
    if (productOptional.isPresent()) {
      df.setStatus(Boolean.TRUE);
      df.setData(convertEntitytoDto(productOptional.get()));
      df.setMessage("Produk Ditemukan");
    } else {
      df.setStatus(Boolean.FALSE);
      df.setMessage("Produk Tidak Ditemukan");
    }
    return df;
  }

  @GetMapping("/sort/bydate") //buat sort produk terbaru
  public List<ProductDto> getListNewProduct() {
    List<ProductDto> list = new ArrayList<>();
    for (Product p : productRepository.getListNewProduct()) {
      list.add(convertEntitytoDto(p));
    }
    return list;
  }

  @GetMapping("/sort/byhighprice") //buat sort produk termahal
  public List<ProductDto> getListHighPrice() {
    List<ProductDto> list = new ArrayList<>();
    for (Product p : productRepository.getListHighPrice()) {
      list.add(convertEntitytoDto(p));
    }
    return list;
  }

  @GetMapping("/sort/bylowprice") // buat sort produk termurah
  public List<ProductDto> getListLowPrice() {
    List<ProductDto> list = new ArrayList<>();
    for (Product p : productRepository.getListLowPrice()) {
      list.add(convertEntitytoDto(p));
    }
    return list;
  }

  @GetMapping("/sort/bybestseller") //buat sort penjualan terbanyak
  public List<BestSellerDto> getListBestSeller() {
    List<BestSellerDto> list = productRepository.getListBestSeller();

    return list;
  }


  @PostMapping("/save") // buat nyimpen produk di database
  public DefaultResponse<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
    Product product = convertDtoToEntity(productDto);
    DefaultResponse<ProductDto> response = new DefaultResponse<>();
    Optional<Product> optionalProduct = productRepository.findByProductId(productDto.getProductId());
    if (optionalProduct.isPresent()) {
      response.setStatus(Boolean.FALSE);
      response.setMessage("Gagal Menyimpan, Produk Telah Tersedia");
    } else {
      productRepository.save(product);
      response.setStatus(Boolean.TRUE);
      response.setMessage("Produk Berhasil Disimpan");
      response.setData(productDto);
    }
    return response;
  }

  public Product convertDtoToEntity(ProductDto dto) {
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

  public ProductDto convertEntitytoDto(Product entity) {
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
