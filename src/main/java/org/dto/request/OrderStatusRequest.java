package org.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderStatusRequest {
    private String order_id;
}
