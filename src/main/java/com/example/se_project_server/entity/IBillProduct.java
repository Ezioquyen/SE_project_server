package com.example.se_project_server.entity;

import org.springframework.stereotype.Component;

@Component
public interface IBillProduct {
    String getName();
    Integer getCount();
}

