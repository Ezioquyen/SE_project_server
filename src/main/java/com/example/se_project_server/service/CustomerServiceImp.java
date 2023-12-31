package com.example.se_project_server.service;

import com.example.se_project_server.entity.Customer;
import com.example.se_project_server.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean isCustomerExist(String phoneNumber) {
        return customerRepository.existsCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public Customer getCustomer(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public String saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return "done";
    }
}
