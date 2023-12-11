package com.example.se_project_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "ingredient_bill")
public class IngredientBill {
    @Id
    private String id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    private String buyDate;
    private Integer cost;
}
