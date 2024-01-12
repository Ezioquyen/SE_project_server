package com.example.se_project_server.service;

import com.example.se_project_server.entity.Staff;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Component
public interface StaffService {
    Staff saveStaff(Staff staff);
    List<Staff> getAllStaff();
    Staff getStaffById(String id);
    Staff updateStaff(Staff staff, String id);
    void deleteStaff(String id);

}
