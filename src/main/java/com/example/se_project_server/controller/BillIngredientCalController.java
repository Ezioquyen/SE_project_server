package com.example.se_project_server.controller;

import com.example.se_project_server.entity.TimeRequest;
import com.example.se_project_server.service.BillIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"billIngredientCal"})
public class BillIngredientCalController {
    private  final BillIngredientService billIngredientService;

    public BillIngredientCalController(BillIngredientService billIngredientService) {
        this.billIngredientService = billIngredientService;
    }

    @PostMapping({"getCount"})
    public ResponseEntity<?> getIngredientCount(@RequestBody TimeRequest timeRequest){
        return  ResponseEntity.ok(this.billIngredientService.getIngredientCount(timeRequest.getDateStart(), timeRequest.getDateEnd()));
    }
    @PostMapping({"getPerDay"})
    public ResponseEntity<?> getBIPerDay(@RequestBody TimeRequest timeRequest){
        return  ResponseEntity.ok(this.billIngredientService.getBIPerDay(timeRequest.getDateStart(), timeRequest.getDateEnd()));
    }
    @PostMapping({"getPerMonth"})
    public ResponseEntity<?> getBIPerMonth(@RequestBody TimeRequest timeRequest){
        return  ResponseEntity.ok(this.billIngredientService.getBIPerMonth(timeRequest.getDateStart(), timeRequest.getDateEnd()));
    }
}
