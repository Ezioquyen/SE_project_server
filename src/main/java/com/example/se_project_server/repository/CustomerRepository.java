package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Boolean existsCustomerByPhoneNumber(String phoneNumber);
    Customer findByPhoneNumber(String phoneNumber);
}
