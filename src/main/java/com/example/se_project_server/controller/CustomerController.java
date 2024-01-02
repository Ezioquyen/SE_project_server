package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Customer;
import com.example.se_project_server.service.CustomerService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/getByPhone")
    public ResponseEntity<?> getCustomerByPhone(@Param("phoneNumber") String phoneNumber){
        return ResponseEntity.ok(customerService.getCustomer(phoneNumber));
    }
    @GetMapping("/check/{phoneNumber}")
    public Boolean checkCustomer(@PathVariable String phoneNumber){
        return customerService.isCustomerExist(phoneNumber);
    }
    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
}
