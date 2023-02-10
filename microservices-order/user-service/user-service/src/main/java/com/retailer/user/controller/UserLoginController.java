package com.retailer.user.controller;

import com.retailer.user.dto.UserLoginResponse;
import com.retailer.user.model.UserLogin;
import com.retailer.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;
    @GetMapping("/test-server")
    public String getMessage() {
    return"User login Server is up now...";
}
    @GetMapping(path = "/={id}", produces = "application/json")
    public UserLoginResponse getUserIdDetails(@PathVariable(value = "id") Integer userId){
        System.err.println("user ID"+ userId);
        Optional<UserLogin> userResponse = userLoginService.getUser(userId);
        if(userResponse.isPresent()){
            return UserLoginResponse.builder()
                    .id(userResponse.get().getId())
                    .userName(userResponse.get().getUsername())
                    .userEmail(userResponse.get().getUserEmail())
                    .build();
        }
        return UserLoginResponse.builder()
                .message("User Id not found...").build();
    }
    @GetMapping(path = "/all",produces = "application/json")
    public List<UserLogin> getUserDetails(){
        return userLoginService.getUserDetails();
    }
    @PostMapping(path = "/save",produces = "application/json")
    public ResponseEntity<?> CreateUser(@RequestBody UserLogin user){
     try {
       userLoginService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
     }catch (Exception e){
         return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
     }
    }

}
