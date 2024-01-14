package com.example.se_project_server.controller;

import com.example.se_project_server.service.OrderBillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/orderBill")
public class OrderBillController {
    private final OrderBillService orderBillService;

    public OrderBillController(OrderBillService orderBillService) {
        this.orderBillService = orderBillService;
    }
    @PutMapping("/saveBill")
    public String createBill(@RequestBody Map<String,Object> body)  {
        return orderBillService.saveBill(body);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(orderBillService.getAllOrderBill());
    }
}
