package org.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
@Builder
public class Order {
    private String order_id;
    private int amount;
    private String currency;
    private String order_description;
    private String orderItems;
    private String orderDate;
    private int orderNumber;
    private String type;
    private int settleInterval;
    private int retryAttempt;
    private boolean force3ds;
    private List<String> googlePayAllowedAuthMethods;
    private String customerDateOfBirth;
    private String customerEmail;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    private String trafficSource;
    private String transactionSource;
    private String purchaseCountry;
    private String geoCountry;
    private String geoCity;
    private String language;
    private String website;
    private Map<String, String> orderMetadata;
    private String successUrl;
    private String failUrl;
}
