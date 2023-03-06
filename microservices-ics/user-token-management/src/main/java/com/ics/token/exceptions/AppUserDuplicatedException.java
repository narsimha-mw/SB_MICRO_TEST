package com.ics.token.exceptions;

public class AppUserDuplicatedException extends AppUserException{
    public AppUserDuplicatedException(String userEmail){
        super(userEmail);
    }
}
