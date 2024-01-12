package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Customer;
import com.example.se_project_server.service.CustomerService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/save")
    public String saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    ////
    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}