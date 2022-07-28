package com.rositasrs.cobalogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping ("/about-us")
public class AboutUsController {
    @GetMapping("/us")
    public String aboutUs(){

        return "Zweeta Collection\n" +
                "Alamat : Kampung Nyegog, RT 01 RW 02, Desa Bentar, kecamatan Salem Brebes Jawa tengah\n" +
                "Owner : Rosita St. Rohimatus Sa'adah\n" +
                "Salem product";
    }
}
