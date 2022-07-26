package com.rositasrs.cobalogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/about-us")
public class AboutUsController {
    @GetMapping("/us")
    public String aboutUs(){

        return "Zweeta Collection\n" +
                "Owner : Rosita St. Rohimatus Sa'adah\n" +
                "salem production\n";
    }
}
