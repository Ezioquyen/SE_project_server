package com.example.se_project_server.service;

import com.example.se_project_server.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StaffService {
    List<Staff> findAllStaff();
    Optional<Staff> findStaffById(String id);
    boolean addStaff(Staff staff);
    boolean updateStaff(Staff staff);
    boolean deleteStaffById(String id);
}
