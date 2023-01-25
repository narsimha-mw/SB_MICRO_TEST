package com.retailer.payment.common;

import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOrder {
//    private Integer id;
    private Long orderNumber;
//    private String productName;
//    private int quantity;
//    private Double price;
    private String message;
    private Enum paymentStatus;

}
