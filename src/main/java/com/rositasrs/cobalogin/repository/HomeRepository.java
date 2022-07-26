package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.dto.projection.BestSeller;
import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeRepository extends JpaRepository <Product, Integer> {

//    Optional<Product> findByProductStockProductStockFinal (Integer ProductStock, Integer ProductStockFinal);
//
//    Optional<Product> findByProductReleseDate(String ProductReleseDate);

//    @Query(value = "select * from table order by tanggal limit ?", nativeQuery = true)
@Query(value = "select * from t_product order by product_release_date desc limit 3", nativeQuery = true)
    List<Product> getProductReleseDate();

    @Query(value = "select product_id, product_name, color_id, product_stock - product_stock_final as total_selling\n" +
            "from t_product\n" + "order by total_selling desc\n" +
            "limit 3", nativeQuery = true)
    List<BestSeller> getBestSeller();

}

