package com.rositasrs.cobalogin.model.entity;

import javax.persistence.*;

@Entity
@Table(name="t_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_address")
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "id_user")
    private Integer userId;
    @Column(name = "nama_penerima")
    private String namaPenerima;
    @Column(name = "no_hp_penerima")
    private String noHpPenerima;
    @Column(name = "alamat_lengkap")
    private String alamatPenerima;
    @Column(name = "kode_pos")
    private Integer kodePos;

    @OneToOne
    @JoinColumn (name = "id_user", insertable = false, updatable = false)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}