package com.rositasrs.cobalogin.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {
    @Id
    @Column(name = "id_user")
    private Integer iduser;
    @Column(name = "username", length = 15, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "nama_lengkap", length = 30)
    private String namalengkap;
    @Column(name = "email", length = 30)
    private String email;
    @Column(name = "no_hp", length = 15)
    private String nohp;
    @Column(name = "id_alamat_pengiriman")
    private Integer alamatpengiriman;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public Integer getAlamatpengiriman() {
        return alamatpengiriman;
    }

    public void setAlamatpengiriman(Integer alamatpengiriman) {
        this.alamatpengiriman = alamatpengiriman;
    }
}
