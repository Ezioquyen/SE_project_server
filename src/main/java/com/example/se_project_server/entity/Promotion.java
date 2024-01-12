package com.example.se_project_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String information;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean needCondition;
    private String name;
    @OneToMany(mappedBy = "promotion")
    @JsonIgnore
    private List<ProductPromotion> productPromotions;
}
