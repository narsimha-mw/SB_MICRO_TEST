package com.retailer.user.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGlobalValues {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private List role;
}
