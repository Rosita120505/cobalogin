package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.repository.AboutUsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aboutus")
public class AboutUsController {
    private AboutUsRepository aboutUsRepository;

    public AboutUsController(AboutUsRepository aboutUsRepository) {
        this.aboutUsRepository = aboutUsRepository;
    }
}
