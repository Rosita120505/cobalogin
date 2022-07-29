package com.rositasrs.cobalogin.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.OneToOne;
import java.util.Date;

public class ProductDto {

  private String productId;
  private String productName;
  private String colorId;
  private Integer productStock;
  private Double price;
  private String productDescription;
  private Double productWeight;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd"/* HH:mm:ss*/)
  private Date productReleaseDate;
  private Integer productStockFinal;
  private String productType;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getColorId() {
    return colorId;
  }

  public void setColorId(String colorId) {
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

  public Date getProductReleaseDate() {
    return productReleaseDate;
  }

  public void setProductReleaseDate(Date productReleaseDate) {
    this.productReleaseDate = productReleaseDate;
  }

  public Integer getProductStockFinal() {
    return productStockFinal;
  }

  public void setProductStockFinal(Integer productStockFinal) {
    this.productStockFinal = productStockFinal;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }
}
