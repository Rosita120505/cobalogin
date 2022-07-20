package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.HomeRepository;
import net.bytebuddy.pool.TypePool;
import org.hibernate.mapping.Array;
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

    @GetMapping ("/latest-product")
    public DefaultResponse getByProductReleseDate(){
        // kumpulan data sebanyak kita
        List<Product> productList = homeRepository.findByProductReleseDate();
        DefaultResponse<List<ProductDto>> result = new DefaultResponse();
        List<ProductDto> productDtoList = new ArrayList();
        for(Product product :  productList){
            // masing2 product ini di convert ke dto
            productDtoList.add(productDtoList) // hasil dari convert to dto
        }
        // kasih kondisinya
        result.setMessage("Berikut Adalah 3 Product Terbaru");
        result.setStatus(Boolean.TRUE);
        result.setData(productDtoList);
        return result;
    }

//    @GetMapping("/latest")
//    //3 produk terbaru
//    public DefaultResponse getByProductReleseDate (@PathVariable String productReleseDate) {
//        DefaultResponse df = new DefaultResponse();
//        Optional <Product> productOptional = homeRepository.findByProductReleseDate();
//        if (productOptional.isPresent()) {
//            df.setStatus(Boolean.TRUE);
//            df.setMessage("Product Relese Date Ditemukan");
//        } else {
//            df.setStatus(Boolean.FALSE);
//            df.setMessage("Product Relese Date Tidak Ditemukan");
//        }
//          return df;
//    }

//    @GetMapping("/best")
//    // 3 best product
//    public List <ProductDto> getListProduct() {
//
//        return best;
//    }

    public Product convertDtoToEntity(ProductDto dto) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setProductStock(dto.getProductStock());
        product.setPrice(dto.getPrice());
        product.setProductReleaseDate(dto.getProductReleaseDate());
        product.setProductStockFinal(dto.getProductStockFinal());

        return product;
    }

    public ProductDto convertEntityToDto (Product entity) {
        ProductDto dto = new ProductDto();
        dto.setProductId(entity.getProductId());
        dto.setProductName(entity.getProductName());
        dto.setProductStock(entity.getProductStock());
        dto.setPrice(entity.getPrice());
        dto.setProductReleaseDate(entity.getProductReleaseDate());
        dto.setProductStockFinal(entity.getProductStockFinal());

        return dto;
    }
}
