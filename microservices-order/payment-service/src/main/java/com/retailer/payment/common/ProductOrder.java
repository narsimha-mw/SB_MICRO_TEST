package com.retailer.payment.common;

import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOrder {
    private int orderNumber;
    private String message;
    private boolean paymentStatus;

}
