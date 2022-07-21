package com.rositasrs.cobalogin.model.entity;

import javax.persistence.*;

@Entity
@Table(name="t_userprofile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profile")
    @Column (name="profile_id")
    private Integer profileId;

    @Column (name="user_id")
    private Integer userId;

    @Column (name="address")
    private String address;

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
