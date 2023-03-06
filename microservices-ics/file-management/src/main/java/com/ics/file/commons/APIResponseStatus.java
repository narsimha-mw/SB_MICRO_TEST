package com.ics.file.commons;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class APIResponseStatus {
    private String message;
    private HttpStatus statusCode;

}
