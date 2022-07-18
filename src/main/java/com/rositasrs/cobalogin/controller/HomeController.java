package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.HomeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {

        this.homeRepository = homeRepository;
    }

    @GetMapping("/best")
    //produk best seller
    public List<ProductDto> getListProduct(){
        List<ProductDto> best = new ArrayList<>();
//        for(Product p :homeRepository.findByProductId()){
//        for(Order o :homeRepository.findByOrderId()){
          for(Product p :homeRepository.findAll()){
            best.add(convertEntitytoDto(p));
        }
        return best;
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

    private ProductDto convertEntitytoDto(Product entity) {
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
