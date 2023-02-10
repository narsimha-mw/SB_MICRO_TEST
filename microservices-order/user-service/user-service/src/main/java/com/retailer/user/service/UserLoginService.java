package com.retailer.user.service;

import com.retailer.user.model.UserLogin;

import java.util.List;
import java.util.Optional;

public interface UserLoginService  {
    UserLogin createUser(UserLogin user);

    List<UserLogin> getUserDetails();

    Optional<UserLogin> getUser(Integer userId);

}
