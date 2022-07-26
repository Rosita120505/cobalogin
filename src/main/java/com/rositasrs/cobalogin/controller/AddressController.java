package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.AddressDto;
import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.RegisterDto;
import com.rositasrs.cobalogin.model.entity.Address;
import com.rositasrs.cobalogin.model.entity.User;
import com.rositasrs.cobalogin.repository.AddressRepository;
import com.rositasrs.cobalogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/save")
    public DefaultResponse saveaddress(@RequestBody AddressDto addressDto){
        Address address = convertDtoToEntity(addressDto);
        DefaultResponse response = new DefaultResponse();
        Optional<Address> optional = addressRepository.findByAddressId(addressDto.getAddressId());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, Alamat Sudah Tersedia");
        } else {
            addressRepository.save(address);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Berhasil Simpan Data");
        }

        return response;
    }

    public Address convertDtoToEntity(AddressDto dto){
        Address address = new Address();
        address.setAddressId(dto.getAddressId());
        address.setUserId(dto.getUserId());
        address.setAlamatPenerima(dto.getAlamatPenerima());
        address.setNamaPenerima(dto.getNamaPenerima());
        address.setNoHpPenerima(dto.getNoHpPenerima());
        address.setKodePos(dto.getKodePos());

        return address;
    }

}
