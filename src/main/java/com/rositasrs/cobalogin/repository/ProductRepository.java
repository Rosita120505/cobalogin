package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.dto.projection.BestSellerDto;
import com.rositasrs.cobalogin.model.dto.projection.LatestProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  Optional<Product> findByProductId (Integer productId);

  List<Product> findAllByProductType(String productType);

  @Query(value = "select * from t_product order by product_release_date desc", nativeQuery = true)
  List<Product> getListNewProduct();

  @Query(value = "select * from t_product order by price desc", nativeQuery = true)
  List<Product> getListHighPrice();

  @Query(value = "select * from t_product order by price", nativeQuery = true)
  List<Product> getListLowPrice();

  @Query(value = "select product_id productId, product_name productName, color_id colorId, product_stock - product_stock_final as totalSelling\n" +
          "from t_product\n" +
          "order by totalSelling desc;", nativeQuery = true)
  List<BestSellerDto> getListBestSeller();

}
