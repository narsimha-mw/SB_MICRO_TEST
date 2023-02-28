package com.retailer.user.controller;

import com.retailer.user.dto.AuthenticationMyUserRequest;
import com.retailer.user.dto.AuthenticationMyUserResponse;
import com.retailer.user.dto.AuthenticationRequest;
import com.retailer.user.model.MyAppUser;
import com.retailer.user.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/user")
@CrossOrigin
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthenticationService authenticationService;
    @GetMapping("/")
    public String msg(){
        return "User service is running......";
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationMyUserResponse> userLogin(@RequestBody AuthenticationRequest request){
        System.err.println("login:"+ request.getUserEmail());
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationMyUserResponse> createUser(@RequestBody AuthenticationMyUserRequest request){
        System.err.println("post register call"+ request
                .getUserEmail());
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @GetMapping("/getUser/email={userEmail}")
    public String getUserById(@PathVariable("userEmail") String userEmail){
        Optional<MyAppUser> userDetails = authenticationService.getUserByUserEmail(userEmail);
        return userDetails.get().getUserEmail();

    }
    @GetMapping("/all")
    public List<MyAppUser> getAllUser(){
        return authenticationService.getAllUser();
//        return userDetails.get().getUserEmail();

    }
}