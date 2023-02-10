package com.retailer.user.exception;
public class AppUserNotFoundException extends AppUserException{
    public AppUserNotFoundException(String userEmail) {
        super(userEmail);
    }
}
