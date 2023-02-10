package com.retailer.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationMyUserRequest {
    private String userEmail;
    private String userPassword;
    private String userName;
}
