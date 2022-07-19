package com.rositasrs.cobalogin.model.dto;

public class ProductDto {

  private Integer productId;
  private String productName;
  /*private ?????? image;*/
  private Integer colorId;
  private Integer productStock;
  private Double price;
  private String productDescription;
  private Double productWeight;
  private Integer productReleaseDate;
  private Integer productStockFinal;

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

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
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

  public Integer getProductStockFinal() {
    return productStockFinal;
  }

  public void setProductStockFinal(Integer productStockFinal) {
    this.productStockFinal = productStockFinal;
  }
}
