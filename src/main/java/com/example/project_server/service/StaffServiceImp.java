package com.example.se_project_server.service;

import com.example.se_project_server.entity.Staff;
import com.example.se_project_server.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StaffServiceImp implements StaffService{
    private final StaffRepository staffRepository;

    public StaffServiceImp(StaffRepository staffRepository) {
        super();
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff saveStaff(Staff staff) {

        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(String id) {
        return staffRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Staff updateStaff(Staff staff, String id) {
        Staff exisStaff = getStaffById(id);
        exisStaff.setName(staff.getName());
        exisStaff.setEmail(staff.getEmail());
        exisStaff.setDob(staff.getDob());
        exisStaff.setPhoneNumber(staff.getPhoneNumber());
        exisStaff.setAddress(staff.getAddress());
        exisStaff.setGender(staff.getGender());
        exisStaff.setRole(staff.getRole());
        exisStaff.setSalaryPerDay(staff.getSalaryPerDay());

        return saveStaff(exisStaff);
    }

    @Override
    public void deleteStaff(String id) {
        staffRepository.deleteAllById(Collections.singleton(id));
//        staffRepository.findById(id).orElseThrow(null);
        staffRepository.deleteById(id);
    }
}
