package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.repository.HomeRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home")
public class HomeController {

    private HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }
}
