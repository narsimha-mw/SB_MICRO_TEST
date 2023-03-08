package com.ics.supervisor.controllers;

import com.ics.supervisor.dtos.SupervisorResponse;
import com.ics.supervisor.models.Supervisor;
import com.ics.supervisor.services.SupervisorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;
    @GetMapping("/test-server" )
    public String test(){

        return "AdminUserService is running...";
    }
    @PostMapping("/save" )
    public ResponseEntity<Supervisor> saveAdmin(@RequestBody Supervisor superVisorRequest){
        Supervisor supervisor = supervisorService.save(superVisorRequest);
        return ResponseEntity.ok().body(supervisor);
    }
    @GetMapping("getId/{market_id}")
    public ResponseEntity<SupervisorResponse> getSupervisorInfo(@PathVariable("market_id") int id){
        SupervisorResponse supervisor = supervisorService.getMarketId(id);
        return ResponseEntity.ok().body(supervisor);
    }

}

