package com.retailer.order.common;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserClient {
    private Integer id;
    private String userEmail;
    private String userName;}
