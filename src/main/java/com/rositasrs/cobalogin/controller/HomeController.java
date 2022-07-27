
package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.dto.projection.BestSellerDto;
import com.rositasrs.cobalogin.model.dto.projection.LatestProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.HomeRepository;
import com.rositasrs.cobalogin.repository.ProductRepository;
import net.bytebuddy.pool.TypePool;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/home")
public class HomeController {

    private HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/hello")
    public String hello(){

        return "Welcome to Zweeta Collection\n" +
                "Please choose your suitable product";
    }

    @GetMapping("/latest")
    public List<LatestProductDto> getListLatestProduct(){
        List<LatestProductDto> result = homeRepository.getListLatestProduct();

        return result;
    }

    @GetMapping("/best-seller")
    public List<BestSellerDto> getBestSeller () {
        List<BestSellerDto> result = homeRepository.getBestSeller();

        return result;
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
//        dto.setProductType(entity.getProductType());
//
//        return dto;
//    }
}
