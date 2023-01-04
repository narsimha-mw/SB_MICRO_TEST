package com.retailer.dto;

import com.retailer.dto.OrderLineItemRequest;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private List<OrderLineItemRequest> orderLineItemRequestList;

}
