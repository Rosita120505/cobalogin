package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  Optional<Product> findByProductId (Integer productId);
  Optional<Product> findByProductType (String productType);

  @Query(value = "select * from t_product order by product_release_date desc", nativeQuery = true) //untuk sort by date
  List<Product> getListNewProduct();

  @Query(value = "select * from t_product order by price desc", nativeQuery = true) //untuk sort by high price
  List<Product> getListHighPrice();

  @Query(value = "select * from t_product order by price", nativeQuery = true) //untuk sort by low price
  List<Product> getListLowPrice();
}
