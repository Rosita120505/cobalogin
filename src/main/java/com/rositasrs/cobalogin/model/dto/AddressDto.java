package com.rositasrs.cobalogin.model.dto;

import javax.persistence.Column;

public class AddressDto {

    private Integer addressId;
    private String namaPenerima;
    private Integer noHpPenerima;
    private String alamatPenerima;
    private Integer kodePos;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public Integer getNoHpPenerima() {
        return noHpPenerima;
    }

    public void setNoHpPenerima(Integer noHpPenerima) {
        this.noHpPenerima = noHpPenerima;
    }

    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public Integer getKodePos() {
        return kodePos;
    }

    public void setKodePos(Integer kodePos) {
        this.kodePos = kodePos;
    }
}
