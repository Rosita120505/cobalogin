package com.rositasrs.cobalogin.model.dto;

public class ProductDto {

  private String productName;
  /*private ?????? image;*/
  private Integer colorId;
  private Integer productStock;
  private Double price;
  private String description;
  private Double productWeight;
  private Integer productReleaseDate;

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
