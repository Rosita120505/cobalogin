package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.LoginDto;
import com.rositasrs.cobalogin.model.dto.ProfileDto;
import com.rositasrs.cobalogin.model.entity.Profile;
import com.rositasrs.cobalogin.model.entity.User;
import com.rositasrs.cobalogin.repository.ProfileRepository;
import com.rositasrs.cobalogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {

        this.profileRepository = profileRepository;
    }

    //fill profile data
    @PostMapping("/fill-profile")
    public DefaultResponse saveProfile (@RequestBody ProfileDto profileDto) {
        Profile profile = convertDtoToEntity (profileDto);
        DefaultResponse result = new DefaultResponse();
        Optional<Profile> opsi = profileRepository.findById(profileDto.getProfileId());
        if (opsi.isPresent()) {
            result.setStatus(Boolean.FALSE);
            result.setMessage("ERROR, Data Sudah Ada");
        } else {
            profileRepository.save(profile);
            result.setStatus(Boolean.TRUE);
            result.setMessage("Data Berhasil Disimpan");
        }

        return result;
    }

    //convert Dto to Entity
    public Profile convertDtoToEntity (ProfileDto dto) {
        Profile prof = new Profile();
        prof.setProfileId(dto.getProfileId());
        prof.setUserId(dto.getUserId());
        prof.setAddress(dto.getAddress());

        return prof;
    }
}
