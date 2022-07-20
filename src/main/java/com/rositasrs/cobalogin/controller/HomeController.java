package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.HomeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping ("/home")
public class HomeController {

    private HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @GetMapping ("/latest-product")
    public DefaultResponse getByProductReleseDate(){
        // menampilkan tiga buah produk terbaru
        List<Product> productList = homeRepository.findByProductReleseDate();
        DefaultResponse<List<ProductDto>> result = new DefaultResponse();
        List<ProductDto> productDtoList = new ArrayList();
        for(Product product :  productList){
            // masing-masing product ini di convert ke dto
            productDtoList.add(convertEntityToDto(product)); // hasil dari convert to dto
        }
        // kasih kondisinya
        result.setMessage("Berikut Adalah 3 Product Terbaru");
        result.setStatus(Boolean.TRUE);
        result.setData(productDtoList);
        return result;
    }

//3 Product best seller (postponed)

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

    public ProductDto convertEntityToDto (Product entity) {
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
