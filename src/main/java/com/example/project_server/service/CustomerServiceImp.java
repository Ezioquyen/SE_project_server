package com.example.project_server.service;

import com.example.project_server.entity.Customer;
import com.example.project_server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean isCustomerExist(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean isCustomerExist(String phoneNumber) {
        return false;
    }

    @Override
    public Optional<Customer> getCustomer(String phoneNumber) {
        return Optional.empty();
    }

    @Override
    public String saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return "done";
    }
    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    ////
    @Override
    public Customer updateCustomer(Long id, Customer newCustomer) {
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
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
