package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.HomeRepository;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping ("/home")
public class HomeController {

    private HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @GetMapping("/best")
    public List<ProductDto> getListProduct() {
        List<ProductDto> best = new ArrayList<>();
        for (Product b: homeRepository.findAll()) {
            best.add(convertEntityToDto(b));
            }
          return best;
    }

    @GetMapping("/latest")
    public List <ProductDto> getListProduct() {
        List<ProductDto> late = new ArrayList<>();
        for (Product l : homeRepository.findAll()) {
            late.add(convertEntityToDto(l));
        }
        return late;
    }

//    public Product convertDtoToEntity(ProductDto dto) {
//        Product product = new Product();
//        product.setProductId(dto.getProductId());
//        product.setProductName(dto.getProductName());
//        product.setProductStock(dto.getProductStock());
//        product.setPrice(dto.getPrice());
//        product.setProductReleaseDate(dto.getProductReleaseDate());
//        product.setProductStockFinal(dto.getProductStockFinal());
//
//        return product;
//    }

//    public ProductDto convertEntityToDto (Product entity) {
//        ProductDto dto = new ProductDto();
//        dto.setProductId(entity.getProductId());
//        dto.setProductName(entity.getProductName());
//        dto.setProductStock(entity.getProductStock());
//        dto.setPrice(entity.getPrice());
//        dto.setProductReleaseDate(entity.getProductReleaseDate());
//        dto.setProductStockFinal(entity.getProductStockFinal());
//
//        return dto;
    }
}
