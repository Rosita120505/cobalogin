package com.rositasrs.cobalogin.model.dto.projection;

import java.util.Date;

public interface OrderHistoryDto {
    Integer getOrderId();
    Integer getNumberofProduct();
    Double getTotalPayment();
    String getOrderStatus();
    Date getOrderDate();
    Date getDeliveryDate();
    Date getReceivedDate();
}
