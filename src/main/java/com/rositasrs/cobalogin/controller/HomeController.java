package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.repository.HomeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/home")
public class HomeController {

    private final HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }


}
