package com.example.se_project_server.entity;

import org.springframework.stereotype.Component;

@Component
public interface ISalaryCal {
    String getId();
    String getName();
    Integer getSalary();
}

