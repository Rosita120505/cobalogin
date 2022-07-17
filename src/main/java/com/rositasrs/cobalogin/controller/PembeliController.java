package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.LoginDto;
import com.rositasrs.cobalogin.model.entity.Pembeli;
import com.rositasrs.cobalogin.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {

    @Autowired
    private PembeliRepository pembeliRepository;

    /*untuk mengakses -- /pembeli/login */
    @PostMapping("/login")
    public DefaultResponse login(@RequestBody LoginDto loginDto){

        Optional<Pembeli> optionalPembeli = pembeliRepository.findByUsernameAndPassword(loginDto.getUname(),loginDto.getPass());

        DefaultResponse df = new DefaultResponse();
        if(optionalPembeli.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Berhasil Login");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Username atau Password Salah");
        }


        return df;
    }
}
