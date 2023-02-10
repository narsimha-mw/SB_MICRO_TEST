package com.retailer.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpiredJwtException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ExpiredJwtException() {
        super();
    }

    public ExpiredJwtException(String message) {
        super(message);
        System.err.println("Error String is called");
    }

    public ExpiredJwtException(String message, Throwable cause) {
        super(message, cause);
        System.err.println("Error String is called: " + message);

    }
}
