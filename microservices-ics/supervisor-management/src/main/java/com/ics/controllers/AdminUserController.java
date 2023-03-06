package com.ics.controllers;

import com.ics.dtos.SuperVisorRequest;
import com.ics.dtos.SuperVisorResponse;
import com.ics.models.AdminUser;
import com.ics.services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/supervisor")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;
    @GetMapping("/test-server" )
    public String test(){
        return "AdminUserService is running...";
    }
    @PostMapping("/save" )
    public ResponseEntity<String> saveAdmin(@RequestBody AdminUser superVisorRequest){
        AdminUser adminUser = adminUserService.save(superVisorRequest);
        return ResponseEntity.ok().body("success");
    }
}

