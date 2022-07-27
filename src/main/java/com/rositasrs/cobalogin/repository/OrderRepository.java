package com.rositasrs.cobalogin.repository;


import com.rositasrs.cobalogin.model.dto.projection.OrderHistoryDto;
import com.rositasrs.cobalogin.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByOrderId(Integer orderId);

    @Query(value = "Select order_id as orderId , number_of_product as numberofProduct, total_payment as totalPayment, order_status as orderStatus, order_date as orderDate, delivery_date as deliveryDate, receive_date as receivedDate \n" +
            "from t_order", nativeQuery = true)
    List<OrderHistoryDto> getListHistoryOrder();
}
