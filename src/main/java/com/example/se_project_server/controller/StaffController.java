package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Staff;
import com.example.se_project_server.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/find-all")
    public List<Staff> findAllStaff(){
        return staffService.findAllStaff();
    }

    @GetMapping("/find/{id}")
    public Optional<Staff> findById(@PathVariable String id){
        return staffService.findStaffById(id);
    }

    @PostMapping("/add-staff")
    public void addStaff(@RequestBody Staff staff){
        staffService.addStaff(staff);
    }

    @PutMapping("/update")
    public void updateStaff(@RequestBody Staff staff){
        staffService.updateStaff(staff);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStaff(@PathVariable String id){
        staffService.deleteStaffById(id);
    }
}
