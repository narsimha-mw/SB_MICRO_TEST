package com.retailer.user.exception;

public class AppUserDuplicatedException extends AppUserException{
    public AppUserDuplicatedException(String userEmail){
        super(userEmail);
    }
}
