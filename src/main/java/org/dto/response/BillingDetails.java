package org.dto.response;

import lombok.Data;

@Data
public class BillingDetails {
    private String address;
    private String city;
    private String country;
    private String state;
    private String zip;
}
