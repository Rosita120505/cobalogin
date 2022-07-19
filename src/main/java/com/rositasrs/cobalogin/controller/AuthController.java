package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.LoginDto;
import com.rositasrs.cobalogin.model.dto.RegisterDto;
import com.rositasrs.cobalogin.model.entity.User;
import com.rositasrs.cobalogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    /*untuk mengakses -- /auth/login */
    @GetMapping("/login")
    public DefaultResponse login(@RequestBody LoginDto loginDto){

        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(loginDto.getUname(),loginDto.getPass());

        DefaultResponse df = new DefaultResponse();
        if(optionalUser.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Berhasil Login");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Username atau Password Salah");
        }


        return df;
    }

    /*untuk mengakses -- /auth/register */
    @PostMapping("/register")
    public DefaultResponse saveuser(@RequestBody RegisterDto registerDto){
        User user = convertDtoToEntity(registerDto);
        DefaultResponse response = new DefaultResponse();
        Optional<User> optional = userRepository.findByUsername(registerDto.getUsername());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, Data Username Sudah Tersedia");
        } else {
            userRepository.save(user);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Berhasil Simpan Data");
        }

        return response;
    }

    public User convertDtoToEntity(RegisterDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setIduser(dto.getIduser());
        user.setNamalengkap(dto.getNamalengkap());
        user.setEmail(dto.getEmail());
        user.setNohp(dto.getNohp());
        user.setPassword(dto.getPassword());

        return user;
    }
}
