package com.rositasrs.cobalogin.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductDetailDto {
  private String productName;
  private Double price;
  private String productDescription;
  private String colorDescription;


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public String getColorDescription() {
    return colorDescription;
  }

  public void setColorDescription(String colorDescription) {
    this.colorDescription = colorDescription;
  }
}
