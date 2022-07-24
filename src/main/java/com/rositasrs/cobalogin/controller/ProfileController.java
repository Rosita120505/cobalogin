//package com.rositasrs.cobalogin.controller;
//
//import com.rositasrs.cobalogin.model.dto.DefaultResponse;
//import com.rositasrs.cobalogin.model.dto.ProfileDto;
//import com.rositasrs.cobalogin.model.entity.Address;
//import com.rositasrs.cobalogin.repository.ProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/profile")
//public class ProfileController {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    public ProfileController(ProfileRepository profileRepository) {
//
//        this.profileRepository = profileRepository;
//    }
//
//    //fill profile data
//    @PostMapping("/fill-profile")
//    public DefaultResponse saveProfile (@RequestBody ProfileDto profileDto) {
//        Address address = convertDtoToEntity (profileDto);
//        DefaultResponse result = new DefaultResponse();
//        Optional<Address> opsi = profileRepository.findById(profileDto.getProfileId());
//        if (opsi.isPresent()) {
//            result.setStatus(Boolean.FALSE);
//            result.setMessage("ERROR, Data Sudah Ada");
//        } else {
//            profileRepository.save(address);
//            result.setStatus(Boolean.TRUE);
//            result.setMessage("Data Berhasil Disimpan");
//        }
//
//        return result;
//    }
//
//    //convert Dto to Entity
//    public Address convertDtoToEntity (ProfileDto dto) {
//        Address prof = new Address();
//        prof.setProfileId(dto.getProfileId());
//        prof.setUserId(dto.getUserId());
//        prof.setAddress(dto.getAddress());
//
//        return prof;
//    }
//}
