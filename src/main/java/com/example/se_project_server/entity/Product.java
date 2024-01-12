package com.example.se_project_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private Boolean available;
    private String image;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<BillProduct> billProducts;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductPromotion> productPromotions;
}
