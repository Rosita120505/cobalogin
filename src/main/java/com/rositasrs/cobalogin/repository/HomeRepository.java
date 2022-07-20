package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface HomeRepository extends JpaRepository <Product, Integer> {

    Optional<Product> findByProductId (Integer productId);
    Optional<Product> findByProductStockProductStockFinal (Integer ProductStock, Integer ProductStockFinal);

    Optional<Product> findByProductReleseDate(Date ProductRelesedate);
}
