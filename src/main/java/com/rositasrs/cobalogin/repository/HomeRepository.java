package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.dto.projection.BestSellerDto;
import com.rositasrs.cobalogin.model.dto.projection.LatestProductDto;
import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeRepository extends JpaRepository <Product, String> {

//    Optional<Product> findByProductStockProductStockFinal (Integer ProductStock, Integer ProductStockFinal);
//
//    Optional<Product> findByProductReleseDate(String ProductReleseDate);

//    @Query(value = "select * from table order by tanggal limit ?", nativeQuery = true)
@Query(value = "select product_name productName,\n" +
        "price productPrice, product_release_date productReleaseDate,\n" +
        "product_stock_final productStock, product_type productType\n" +
        "from t_product\n" +
        "order by productReleaseDate  desc\n" +
        "Limit 3", nativeQuery = true)
List<LatestProductDto> getListLatestProduct();

    @Query(value = "select product_id productId, product_name productName, color_id colorId, product_stock - product_stock_final as totalSelling\n" +
            "from t_product\n" +
            "order by totalSelling desc limit 3", nativeQuery = true)
    List<BestSellerDto> getBestSeller();

}

