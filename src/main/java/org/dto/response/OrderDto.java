package org.dto.response;

import lombok.Data;

@Data
public class OrderDto {
    private String order_id;
    private String order_description;
    private String subscription_id;
    private String amount;
    private String currency;
    private double processing_amount;
    private String processing_currency;
    private double marketing_amount;
    private String marketing_currency;
    private double refunded_amount;
    private String status;
    private String payment_type;
    private String customer_email;
    private String descriptor;
    private String mid;
    private String traffic_source;
    private boolean fraudulent;
}
