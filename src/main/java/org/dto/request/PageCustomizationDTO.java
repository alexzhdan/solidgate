package org.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageCustomizationDTO {
    private String public_name;
    private String orderTitle;
    private String orderDescription;
    private List<String> paymentMethods;
    private String buttonFontColor;
    private String buttonColor;
    private String fontName;
    private boolean isCardholderVisible;
    private String termsUrl;
    private String backUrl;
}
