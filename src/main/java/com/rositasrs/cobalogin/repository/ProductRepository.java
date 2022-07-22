package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.dto.projection.BestSeller;
import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  Optional<Product> findByProductId (Integer productId);
  //Optional<Product> findByProductType (String productType);

  List<Product> findAllByProductType(String productType);

  @Query(value = "select * from t_product order by product_release_date desc", nativeQuery = true)
  List<Product> getListNewProduct();

  @Query(value = "select * from t_product order by price desc", nativeQuery = true)
  List<Product> getListHighPrice();

  @Query(value = "select * from t_product order by price", nativeQuery = true)
  List<Product> getListLowPrice();

  @Query(value = "select product_id, product_name, color_id, product_stock - product_stock_final as total_selling\n" +
          "from t_product\n" +
          "order by total_selling desc", nativeQuery = true)
  List<BestSeller> getListBestSeller();


}
