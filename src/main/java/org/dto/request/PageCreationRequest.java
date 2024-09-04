package org.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class PageCreationRequest {
    private Order order;
    private PageCustomizationDTO page_customization;
}
