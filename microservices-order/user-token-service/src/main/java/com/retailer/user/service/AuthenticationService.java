package com.retailer.user.service;

import com.retailer.user.dto.AuthenticationRequest;

import com.retailer.user.dto.AuthenticationMyUserRequest;
import com.retailer.user.dto.AuthenticationMyUserResponse;
import com.retailer.user.model.MyAppUser;

import java.util.List;
import java.util.Optional;

public interface AuthenticationService {
    AuthenticationMyUserResponse authenticate(AuthenticationRequest request);

    AuthenticationMyUserResponse register(AuthenticationMyUserRequest request);

//    Optional<MyAppUser> getUserById(Integer userId);

    Optional<MyAppUser> getUserByUserEmail(String userEmail);

    List<MyAppUser> getAllUser();
}
