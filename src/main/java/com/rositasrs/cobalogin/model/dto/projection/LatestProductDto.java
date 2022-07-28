package com.rositasrs.cobalogin.model.dto.projection;

import java.util.Date;

public interface LatestProductDto {

     String getProductName ();
     Double getProductPrice() ;
     Date getProductReleaseDate();
     Integer getProductStock();
     String getProductType();
}
