package com.example.se_project_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "order_bill")
public class OrderBill {
    @Id
    private String id;
    private String buyDate;
    private String customerPhoneNumber;
    private String userStaffId;
}
