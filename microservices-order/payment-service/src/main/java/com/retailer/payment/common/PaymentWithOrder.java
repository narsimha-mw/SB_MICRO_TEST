package com.retailer.payment.common;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentWithOrder {
    private int orderNumber;
    private boolean paymentStatus;
}
