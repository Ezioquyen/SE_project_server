package com.example.project_server.service;

import com.example.project_server.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerService {
    boolean isCustomerExist(Long id);

    Optional<Customer> getCustomer(Long id);

    boolean isCustomerExist(String phoneNumber);
    Optional<Customer> getCustomer(String phoneNumber);
    String saveCustomer(Customer customer);

    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);

    ////
    Customer updateCustomer(Long id, Customer updatedCustomer);

    void deleteCustomer(Long id);
}
