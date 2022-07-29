package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, String> {

  Optional<Color> findByColorId (String colorId);


}
