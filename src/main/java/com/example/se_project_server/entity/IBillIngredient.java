package com.example.se_project_server.entity;

import org.springframework.stereotype.Component;

@Component
public interface IBillIngredient {
    String getName();
    Integer getCount();
    String getUnit();
    Integer getTotal();
}

