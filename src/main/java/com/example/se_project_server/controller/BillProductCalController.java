package com.example.se_project_server.controller;

import com.example.se_project_server.entity.TimeRequest;
import com.example.se_project_server.service.BillProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/billProductCal"})
public class BillProductCalController {
    private  final BillProductService billProductService;

    public BillProductCalController(BillProductService billProductService) {
        this.billProductService = billProductService;
    }

    @PostMapping({"getCount"})
    public ResponseEntity<?> getProductCount(@RequestBody TimeRequest timeRequest){
        return ResponseEntity.ok(this.billProductService.getProductCount(timeRequest.getDateStart().atStartOfDay(), timeRequest.getDateEnd().atStartOfDay().withHour(23).withMinute(59).withSecond(59)));
    }

    @PostMapping({"getPerDay"})
    public ResponseEntity<?> getProfitPerDay(@RequestBody TimeRequest timeRequest){
        return  ResponseEntity.ok(this.billProductService.getProfitPerDay(timeRequest.getDateStart().atStartOfDay(), timeRequest.getDateEnd().atStartOfDay().withHour(23).withMinute(59).withSecond(59)));
    }
    @PostMapping({"getPerMonth"})
    public ResponseEntity<?> getProfitPerMonth(@RequestBody TimeRequest timeRequest){
        return  ResponseEntity.ok(this.billProductService.getProfitPerMonth(timeRequest.getDateStart().atStartOfDay(), timeRequest.getDateEnd().atStartOfDay().withHour(23).withMinute(59).withSecond(59)));
    }
}
