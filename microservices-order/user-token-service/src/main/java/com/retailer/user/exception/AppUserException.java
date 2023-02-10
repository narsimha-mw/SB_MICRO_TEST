package com.retailer.user.exception;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class AppUserException extends Exception{
    protected String userEmail;
}
