package com.rositasrs.cobalogin.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product {

  @Id
  @Column(name = "product_id")
  private Integer productId;
  @Column(name = "product_name")
  private String productName;
  /*private ?????? image;*/
  @Column(name = "color_id")
  private Integer colorId;
  @Column(name = "product_stock")
  private Integer productStock;
  @Column
  private Double price;
  @Column
  private String description;
  @Column(name = "product_weight")
  private Double productWeight;
  @Column(name = "product_release_date")
  private Integer productReleaseDate;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getColorId() {
    return colorId;
  }

  public void setColorId(Integer colorId) {
    this.colorId = colorId;
  }

  public Integer getProductStock() {
    return productStock;
  }

  public void setProductStock(Integer productStock) {
    this.productStock = productStock;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getProductWeight() {
    return productWeight;
  }

  public void setProductWeight(Double productWeight) {
    this.productWeight = productWeight;
  }

  public Integer getProductReleaseDate() {
    return productReleaseDate;
  }

  public void setProductReleaseDate(Integer productReleaseDate) {
    this.productReleaseDate = productReleaseDate;
  }
}
