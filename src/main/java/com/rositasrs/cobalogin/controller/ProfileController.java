package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.dto.ProfileDto;
import com.rositasrs.cobalogin.model.entity.Address;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.model.entity.User;
import com.rositasrs.cobalogin.repository.AddressRepository;
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

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/user")
    public List<ProfileDto> getListUserProfile() {
        List<ProfileDto> list = new ArrayList<>();
        for (Address a : addressRepository.findAll()) {
            list.add(convertEntitytoDto(a));
        }
        return list;
    }

    public ProfileDto convertEntitytoDto(Address entity) {
        ProfileDto dto = new ProfileDto();
        dto.setUserId(entity.getUser().getUserId());
        dto.setUserName(entity.getUser().getUserName());
        dto.setFullName(entity.getUser().getFullName());
        dto.setNoHp(entity.getUser().getNoHp());
        dto.setEmail(entity.getUser().getEmail());
        dto.setAlamatPenerima(entity.getAlamatPenerima());
//        dto.setUserId(entity.getUserId());
//        dto.setUserName(entity.getUserName());
//        dto.setEmail(entity.getEmail());
//        dto.setFullName(entity.getFullName());
//        dto.setNoHp(entity.getNoHp());
//        dto.setAlamatPenerima(entity.getAddress().getAlamatPenerima());

        return dto;
    }

}
