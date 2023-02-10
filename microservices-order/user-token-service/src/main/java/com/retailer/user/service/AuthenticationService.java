package com.retailer.user.service;

import com.retailer.user.dto.AuthenticationRequest;

import com.retailer.user.dto.AuthenticationMyUserRequest;
import com.retailer.user.dto.AuthenticationMyUserResponse;

public interface AuthenticationService {
    AuthenticationMyUserResponse authenticate(AuthenticationRequest request);

    AuthenticationMyUserResponse register(AuthenticationMyUserRequest request);
}
