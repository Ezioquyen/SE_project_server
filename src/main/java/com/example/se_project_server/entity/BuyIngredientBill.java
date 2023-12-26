package com.example.se_project_server.entity;


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
@Table(name = "buy_ingredient_bill")
public class BuyIngredientBill {
    @Id
    private String id;
    private String buyDate;
    private Integer cost;
}
