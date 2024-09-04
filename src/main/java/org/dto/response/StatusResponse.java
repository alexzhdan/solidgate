package org.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class StatusResponse {
    private OrderDto order;
    private Map<String, Object> transactions;
    private Map<String, Object> three_ds;
    private Map<String, Object[]> routing;
    private Object pay_form;
    private DeviceInfo device_info;
    private String redirect_url;
    private Object payment_adviser;
}
