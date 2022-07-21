package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeRepository extends JpaRepository <Product, Integer> {

//    Optional<Product> findByProductStockProductStockFinal (Integer ProductStock, Integer ProductStockFinal);
//
//    Optional<Product> findByProductReleseDate(String ProductReleseDate);

//    @Query(value = "select * from table order by tanggal limit ?", nativeQuery = true)
    @Query(value = "select * from product order by product_relese_date limit 3", nativeQuery = true)
    List<Product> findByProductReleseDate();
}

