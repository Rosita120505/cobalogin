package com.rositasrs.cobalogin.model.entity;

import javax.persistence.*;

@Entity
@Table(name="t_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "id_user")
    private Integer userId;
    @Column(name = "nama_penerima")
    private String namaPenerima;
    @Column(name = "no_hp_penerima")
    private Integer noHpPenerima;
    @Column(name = "alamat_lengkap")
    private String alamatPenerima;
    @Column(name = "kode_pos")
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