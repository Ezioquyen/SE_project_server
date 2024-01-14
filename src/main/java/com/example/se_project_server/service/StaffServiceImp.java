package com.example.se_project_server.service;

import com.example.se_project_server.entity.Staff;
import com.example.se_project_server.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImp implements StaffService{
    private final StaffRepository staffRepository;

    public StaffServiceImp(StaffRepository staffRepository) {
        super();
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff saveStaff(Staff staff) {
        if(staffRepository.existsById(staff.getId())) {
           return null;
        } else {
            staff.setIs_removed(false);
            return staffRepository.save(staff);
        }
//        return  staffRepository.save(staff);
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
        exisStaff.setIs_removed(false);
        return  staffRepository.save(exisStaff);
    }

    @Override
    public void deleteStaff(String id) {
       // staffRepository.deleteAllById(Collections.singleton(id));
//        staffRepository.findById(id).orElseThrow(null);
//        staffRepository.deleteById(id);
     //   staffRepository.findById(id);
        Optional<Staff> optionalStaff = staffRepository.findById(id);

        if (optionalStaff.isPresent()) {
            Staff staff = optionalStaff.get();
            // Thực hiện các thao tác với đối tượng Staff đã tìm thấy
            staff.setIs_removed(true);
            staffRepository.save(staff);
        }
    }
}
