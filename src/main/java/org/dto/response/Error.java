package org.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class Error {
    private String code;
    private List<String> messages;
    private String recommended_message_for_user;
    private String merchant_advice_code;
}
