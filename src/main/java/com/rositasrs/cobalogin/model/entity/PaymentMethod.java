package com.rositasrs.cobalogin.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_paymentmethod")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_payment_method")
    @Column(name = "payment_id")
    private Integer paymentId;
    @Column(name = "description")
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
