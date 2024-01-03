//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.se_project_server.controller;

import com.example.se_project_server.entity.TimeAndNameRequest;
import com.example.se_project_server.entity.TimeRequest;
import com.example.se_project_server.service.SalaryCalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/salaryCal"})
public class SalaryCalController {
    private final SalaryCalService salaryCalService;

    public SalaryCalController(SalaryCalService salaryCalService) {
        this.salaryCalService = salaryCalService;
    }

    @PostMapping({"/getAll"})
    public ResponseEntity<?> getAllSalaryCal(@RequestBody TimeRequest timeRequest) {
        return ResponseEntity.ok(this.salaryCalService.getAllSalaryCal(timeRequest.getDateStart(), timeRequest.getDateEnd()));
    }

    @PostMapping({"/getBySearching"})
    public ResponseEntity<?> getSalaryBySearching(@RequestBody TimeAndNameRequest timeAndNameRequest) {
        return ResponseEntity.ok(this.salaryCalService.getSalaryBySearching(timeAndNameRequest.getStringSearch(), timeAndNameRequest.getDateStart(), timeAndNameRequest.getDateEnd()));
    }

    @PostMapping({"/getPerDay"})
    public ResponseEntity<?> getSalaryPerDay(@RequestBody TimeRequest timeRequest) {
        return ResponseEntity.ok(this.salaryCalService.getSalaryPerDay(timeRequest.getDateStart(), timeRequest.getDateEnd()));
    }

    @PostMapping({"/getPerMonth"})
    public ResponseEntity<?> getSalaryPerMonth(@RequestBody TimeRequest timeRequest) {
        return ResponseEntity.ok(this.salaryCalService.getSalaryPerMonth(timeRequest.getDateStart(), timeRequest.getDateEnd()));
    }
}
