package com.rositasrs.cobalogin.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_expedition")
public class Expedition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_expedition")
    @Column(name = "delivery_code")
    private Integer deliveryCode;
    @Column(name = "descr")
    private String descr;

    public Integer getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(Integer deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
