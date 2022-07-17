package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PembeliRepository extends JpaRepository<Pembeli, Integer> {

    Optional<Pembeli> findByUsernameAndPassword (String uname, String pass);
}
