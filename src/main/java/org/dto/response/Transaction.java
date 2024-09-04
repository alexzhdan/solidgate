package org.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Transaction {
    private String id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private double amount;
    private String currency;
    private double marketing_amount;
    private String marketing_currency;
    private String operation;
    private String status;
    private String descriptor;
    private BillingDetails billing_details;
    private String refund_reason;
    private String refund_reason_code;
    private CardToken card_token;
    private Card card;
    private Error error;
}
