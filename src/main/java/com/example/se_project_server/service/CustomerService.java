package com.example.se_project_server.service;

import com.example.se_project_server.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CustomerService {
    boolean isCustomerExist(String phoneNumber);
    Customer getCustomer(String phoneNumber);
    String saveCustomer(Customer customer);
    Customer updateCustomer(Integer id, Customer updatedCustomer);
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    void deleteCustomer(Integer id);

}
