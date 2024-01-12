package com.example.se_project_server.service;

import com.example.se_project_server.entity.Staff;
import com.example.se_project_server.repository.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StaffServiceImp implements StaffService{

    private StaffRepository staffRepository;

    @Autowired
    public StaffServiceImp(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findStaffById(String id) {
        return staffRepository.findById(id);
    }

    @Override
    public boolean addStaff(Staff staff) {
        if(staffRepository.existsById(staff.getId())){
            return false;
        }else{
            staffRepository.save(staff);
            return true;
        }

    }

    @Override
    public boolean updateStaff(Staff staff) {
        if(staffRepository.existsById(staff.getId())){
            staffRepository.saveAndFlush(staff);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteStaffById(String id) {
        if(staffRepository.existsById(id)){
            staffRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
