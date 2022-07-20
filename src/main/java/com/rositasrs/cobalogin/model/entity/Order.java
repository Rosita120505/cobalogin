package com.rositasrs.cobalogin.model.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order")
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "number_of_product")
    private Integer numberofProduct;
    @Column(name = "weight_total")
    private Double weightTotal;
    @Column(name = "profil_id")
    private Integer profilId;
    @Column(name = "delivery_code")
    private Integer deliveryCode;
    @Column(name = "shipping_costs")
    private Double shippingCosts;
    @Column(name = "total_payment")
    private Double totalPayment;
    @Column(name = "store_address")
    private String storeAddress;
    @Column(name = "payment_id")
    private Integer paymentId;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "order_status")
    private String orderStatus;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "cart_id")
    private Integer cartId;
    @Temporal(TemporalType.DATE)
    @Column(name = "delivery_date")
    private Date deliveryDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "receive_date")
    private Date receivedDate;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getNumberofProduct() {
        return numberofProduct;
    }

    public void setNumberofProduct(Integer numberofProduct) {
        this.numberofProduct = numberofProduct;
    }

    public Double getWeightTotal() {
        return weightTotal;
    }

    public void setWeightTotal(Double weightTotal) {
        this.weightTotal = weightTotal;
    }

    public Integer getProfilId() {
        return profilId;
    }

    public void setProfilId(Integer profilId) {
        this.profilId = profilId;
    }

    public Integer getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(Integer deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public Double getShippingCosts() {
        return shippingCosts;
    }

    public void setShippingCosts(Double shippingCosts) {
        this.shippingCosts = shippingCosts;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
}
