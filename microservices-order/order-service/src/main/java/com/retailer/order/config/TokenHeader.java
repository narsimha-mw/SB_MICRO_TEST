package com.retailer.order.config;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class TokenHeader {
        private static final String AUTHORIZATION_HEADER = "Authorization";

        public static String getBearerTokenHeader() {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
        }
}
