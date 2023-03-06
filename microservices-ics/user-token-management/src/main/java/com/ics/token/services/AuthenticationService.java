package com.ics.token.services;

import com.ics.token.dtos.AuthenticationRequest;

import com.ics.token.dtos.AuthenticationMyUserRequest;
import com.ics.token.dtos.AuthenticationMyUserResponse;
import com.ics.token.models.MyAppUser;

import java.util.List;
import java.util.Optional;

public interface AuthenticationService {
    AuthenticationMyUserResponse authenticate(AuthenticationRequest request);

    AuthenticationMyUserResponse register(AuthenticationMyUserRequest request);

//    Optional<MyAppUser> getUserById(Integer userId);

    Optional<MyAppUser> getUserByUserEmail(String userEmail);

    List<MyAppUser> getAllUser();
}
