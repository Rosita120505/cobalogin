package com.rositasrs.cobalogin.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_cart")
public class Cart {
    @Id
    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "number_of_order")
    private Integer numberofOrder;

    @Column(name = "total")
    private Double total;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getNumberofOrder() {
        return numberofOrder;
    }

    public void setNumberofOrder(Integer numberofOrder) {
        this.numberofOrder = numberofOrder;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
