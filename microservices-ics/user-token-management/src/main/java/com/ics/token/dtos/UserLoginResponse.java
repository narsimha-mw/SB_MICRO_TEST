package com.ics.token.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponse {
    private Integer id;
    private String userName;
    private String  userEmail;
    private String  message;

}
