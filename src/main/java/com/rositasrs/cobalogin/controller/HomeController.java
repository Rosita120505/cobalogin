package com.rositasrs.cobalogin.controller;

import antlr.collections.List;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.HomeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/home")
public class HomeController {

    private HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @GetMapping("/terbaru")
    public List<ProductDto> getListProduct () {
        List <ProductDto> list = new ArrayList<> ();
    }
}
