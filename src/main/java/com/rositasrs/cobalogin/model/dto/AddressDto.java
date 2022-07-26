package com.rositasrs.cobalogin.model.dto;

public class AddressDto {

    private Integer addressId;
    private Integer userId;
    private String namaPenerima;
    private String noHpPenerima;
    private String alamatPenerima;
    private Integer kodePos;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getNoHpPenerima() {
        return noHpPenerima;
    }

    public void setNoHpPenerima(String noHpPenerima) {
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
