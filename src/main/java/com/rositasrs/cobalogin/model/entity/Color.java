package com.rositasrs.cobalogin.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_color")
public class Color {
  @Id
  @Column(name = "color_id")
  private Integer colorId;
  @Column(name = "color_description")
  private String colorDescription;

  @OneToOne
  @JoinColumn(name = "color_id", updatable = false, insertable = false)
  private Product product;

  public Integer getColorId() {
    return colorId;
  }

  public void setColorId(Integer colorId) {
    this.colorId = colorId;
  }

  public String getColorDescription() {
    return colorDescription;
  }

  public void setColorDescription(String colorDescription) {
    this.colorDescription = colorDescription;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}

