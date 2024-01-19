package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Timekeeping;
import com.example.se_project_server.service.TimekeepingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/timekeeping")
public class TimekeepingController {
    private final TimekeepingService timekeepingService;

    public TimekeepingController(TimekeepingService timekeepingService) {
        this.timekeepingService = timekeepingService;
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveTimekeeping(@RequestBody Map<String, Object> input){
        timekeepingService.saveTimekeeping(input);
        return ResponseEntity.ok(null);
    }
}
