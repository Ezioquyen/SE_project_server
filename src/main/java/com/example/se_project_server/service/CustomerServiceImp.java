package com.example.se_project_server.service;

import com.example.se_project_server.entity.Customer;
import com.example.se_project_server.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    @Override
    public Customer updateCustomer(Integer id, Customer newCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setPhoneNumber(newCustomer.getPhoneNumber());
                    customer.setName(newCustomer.getName());
                    customer.setDob(newCustomer.getDob());
                    return customerRepository.save(customer); // Update the existing customer
                })
                .orElseGet(() ->
                        customerRepository.save(newCustomer));


    }


    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
