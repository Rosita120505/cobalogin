package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart , Integer> {

    Optional<Cart> findByCartId(Integer integer);
}
