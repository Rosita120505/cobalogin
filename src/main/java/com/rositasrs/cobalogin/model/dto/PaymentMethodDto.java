package com.rositasrs.cobalogin.model.dto;

public class PaymentMethodDto {

    private Integer paymentId;
    private String description;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
