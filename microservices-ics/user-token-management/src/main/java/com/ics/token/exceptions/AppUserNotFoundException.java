package com.ics.token.exceptions;
public class AppUserNotFoundException extends AppUserException{
    public AppUserNotFoundException(String userEmail) {
        super(userEmail);
    }
}
