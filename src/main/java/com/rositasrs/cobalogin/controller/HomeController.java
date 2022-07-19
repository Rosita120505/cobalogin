package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.repository.HomeRepository;
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
        List<ProductDto> list = new ArrayList<>();
        for (Product)
    }
}
