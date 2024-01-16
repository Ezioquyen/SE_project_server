package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Staff;
import com.example.se_project_server.service.StaffService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/staff"})
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        super();
        this.staffService = staffService;
    }

    @PostMapping("/save")
    private ResponseEntity<Staff> saveStaff(@RequestBody Staff staff){
        return ResponseEntity.ok(staffService.saveStaff(staff));
    }

    @GetMapping("/getAll")
//    public List<Staff> getAllStaff() {
//        return staffService.getAllStaff();
//    }
    public ResponseEntity<?> getAllStaff(){
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") String id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff, @PathVariable("id") String id) {
        return ResponseEntity.ok(staffService.updateStaff(staff, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") String id){
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Delete success");
    }
}
