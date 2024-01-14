package com.example.se_project_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


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
    private LocalDate buyDate;
    private String customerPhoneNumber;
    private String userStaffId;
    private Integer total;
    private Integer received;
    private Integer changeMoney;
    private Boolean payMethod;
    private Integer deduction;
    private Integer original;
    private String promotionName;
    @OneToMany(mappedBy = "orderBill")
    private List<BillProduct> billProducts;
}
