package com.ics.performances.controller;

import com.ics.performances.dto.SalesRequest;
import com.ics.performances.model.Sales;
import com.ics.performances.model.TargetAchievement;
import com.ics.performances.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/performance/sales")
public class SalesController {


    @Autowired
    private SalesService salesService;
    @GetMapping("/test-server")
    public String show(){
        return "Sales Serve running";
    }
   @PostMapping("/save")
    public ResponseEntity<Sales> save(@RequestBody TargetAchievement request){
       System.err.println("SalesRequest"+ request);
       Sales sales1=  salesService.save(request);
        return ResponseEntity.ok(sales1);
   }
}
