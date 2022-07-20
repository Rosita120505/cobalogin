package com.rositasrs.cobalogin.controller;

import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.OrderDto;
import com.rositasrs.cobalogin.model.entity.Order;
import com.rositasrs.cobalogin.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orderan")
    public List<OrderDto> getListOrder(){
        List<OrderDto> list = new ArrayList<>();
        for(Order o :orderRepository.findAll()){
            list.add(convertEntitytoDto(o));
        }
        return list;
    }
    @PostMapping("/simpan")
    public DefaultResponse<OrderDto> saveOrder(@RequestBody OrderDto orderDto){
        Order order = convertDtotoEntity(orderDto);
        DefaultResponse<OrderDto> response = new DefaultResponse<>();
        Optional<Order> optionalOrder = orderRepository.findByOrderId(orderDto.getOrderId());
        if(optionalOrder.isPresent()){
            response.setMessage("Gagal Menyimpan, Pesanan Telah Tersedia");
        } else{
            orderRepository.save(order);
            response.setMessage("Pesanan berhasil tersimpan");
            response.setData(orderDto);
        }
        return response;

    }
    public Order convertDtotoEntity(OrderDto dto){
        Order order = new Order();
        order.setOrderId(dto.getOrderId());
        order.setOrderDate(dto.getOrderDate());
        order.setOrderStatus(dto.getOrderStatus());
        order.setCartId(dto.getCartId());
        order.setDeliveryCode(dto.getDeliveryCode());
        order.setDeliveryDate(dto.getDeliveryDate());
        order.setNumberofProduct(dto.getNumberofProduct());
        order.setPaymentId(dto.getPaymentId());
        order.setPaymentStatus(dto.getPaymentStatus());
        order.setProfilId(dto.getProfilId());
        order.setReceivedDate(dto.getReceivedDate());
        order.setShippingCosts(dto.getShippingCosts());
        order.setStoreAddress(dto.getStoreAddress());
        order.setTotalPayment(dto.getTotalPayment());
        order.setWeightTotal(dto.getWeightTotal());

        return order;
    }
    public OrderDto convertEntitytoDto(Order entity){
        OrderDto dto = new OrderDto();
        dto.setOrderId(entity.getOrderId());
        dto.setOrderDate(entity.getOrderDate());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setCartId(entity.getCartId());
        dto.setDeliveryCode(entity.getDeliveryCode());
        dto.setDeliveryDate(entity.getDeliveryDate());
        dto.setNumberofProduct(entity.getNumberofProduct());
        dto.setPaymentId(entity.getPaymentId());
        dto.setPaymentStatus(entity.getPaymentStatus());
        dto.setProfilId(entity.getProfilId());
        dto.setReceivedDate(entity.getReceivedDate());
        dto.setShippingCosts(entity.getShippingCosts());
        dto.setStoreAddress(entity.getStoreAddress());
        dto.setTotalPayment(entity.getTotalPayment());
        dto.setWeightTotal(entity.getWeightTotal());

        return dto;
    }
}
