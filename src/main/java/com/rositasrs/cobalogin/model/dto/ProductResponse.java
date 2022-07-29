package com.rositasrs.cobalogin.model.dto;

public class ProductResponse {
  private String productId;
  private String fileType;
  private String message;
  private boolean uploadStatus;
  private String downloadUri;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isUploadStatus() {
    return uploadStatus;
  }

  public void setUploadStatus(boolean uploadStatus) {
    this.uploadStatus = uploadStatus;
  }

  public String getDownloadUri() {
    return downloadUri;
  }

  public void setDownloadUri(String downloadUri) {
    this.downloadUri = downloadUri;
  }
}
