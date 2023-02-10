package com.retailer.user.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class AuthenticationMyUserResponse {
    private String userName;
    private String userEmail;
    private String token;
    private String message;
}
