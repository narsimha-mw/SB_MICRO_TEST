package com.retailer.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/user/test")
@CrossOrigin

public class UserDemoController {
    @GetMapping("/")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Success with User demo controller server");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> createUser(){
        return ResponseEntity.ok("Success with User demo controller");
    }
}