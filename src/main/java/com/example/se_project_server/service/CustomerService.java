package com.example.se_project_server.service;

import com.example.se_project_server.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomerService {
    boolean isCustomerExist(String phoneNumber);
    Optional<Customer> getCustomer(String phoneNumber);
    String saveCustomer(Customer customer);
}
