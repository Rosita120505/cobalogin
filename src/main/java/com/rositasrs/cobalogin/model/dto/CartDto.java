package com.rositasrs.cobalogin.model.dto;

public class CartDto {

    private String cartId;
    private Integer numberofOrder;
    private Double total;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
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