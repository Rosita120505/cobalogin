package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.ColorDto;
import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.ProductDto;
import com.rositasrs.cobalogin.model.entity.Color;
import com.rositasrs.cobalogin.model.entity.Product;
import com.rositasrs.cobalogin.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/color")
public class ColorController {

  @Autowired
  ColorRepository colorRepository;

  @GetMapping("/all") // buat nampilin produk yang ada di database
  public DefaultResponse getListAllColor() {
    DefaultResponse df= new DefaultResponse();
    List<ColorDto> list = new ArrayList<>();
    List<Color> lists = colorRepository.findAll();
    if(lists.size() != 0) {
      for (Color c : lists) {
        df.setMessage("Berikut adalah list semua warna");
        list.add(convertEntitytoDto(c));
      }
      df.setData(list);
    }
    return df;
  }

  @PostMapping("/save")
  public DefaultResponse<ColorDto> saveColor(@RequestBody ColorDto colorDto){
    Color color= convertDtoToEntity(colorDto);
    DefaultResponse<ColorDto> response = new DefaultResponse<>();
    Optional<Color> optionalColor = colorRepository.findByColorId(colorDto.getColorId());
    if (optionalColor.isPresent()) {
      response.setStatus(Boolean.FALSE);
      response.setMessage("Gagal Menyimpan, Warna Telah Tersedia");
    } else {
      colorRepository.save(color);
      response.setStatus(Boolean.TRUE);
      response.setMessage("Warna Berhasil Disimpan");
      response.setData(colorDto);
    }
    return response;


  }

  public Color convertDtoToEntity(ColorDto dto) {
    Color color = new Color();
    color.setColorId(dto.getColorId());
    color.setColorDescription(dto.getColorDescription());

    return color;
  }

  public ColorDto convertEntitytoDto(Color entity) {
    ColorDto dto = new ColorDto();
    dto.setColorId(entity.getColorId());
    dto.setColorDescription(entity.getColorDescription());

    return dto;
  }
}
