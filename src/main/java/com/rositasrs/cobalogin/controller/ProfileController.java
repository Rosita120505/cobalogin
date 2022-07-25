package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.dto.ProfileDto;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.model.entity.User;
import com.rositasrs.cobalogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<ProfileDto> getListUserProfile() {
        List<ProfileDto> list = new ArrayList<>();
        for (User u : userRepository.findAll()) {
            list.add(convertEntitytoDto(u));
        }
        return list;
    }

    public ProfileDto convertEntitytoDto(User entity) {
        ProfileDto dto = new ProfileDto();
        dto.setUserId(entity.getUserId());
        dto.setEmail(entity.getEmail());
        dto.setFullName(entity.getFullName());
        dto.setAlamatPenerima(entity.getAddress().getAlamatPenerima());

        return dto;
    }

}
