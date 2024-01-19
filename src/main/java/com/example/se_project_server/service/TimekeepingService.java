package com.example.se_project_server.service;

import com.example.se_project_server.entity.Timekeeping;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public interface TimekeepingService {
    void saveTimekeeping(Map<String, Object> timekeeping);
}
