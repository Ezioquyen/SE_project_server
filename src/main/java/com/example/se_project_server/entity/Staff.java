package com.example.se_project_server.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "staff")
public class Staff {
    @Id
    private String id;
    private String name;
    private String email;
    private LocalDate dob;
    private String phoneNumber;
    private String address;
    private String gender;
    private Integer salaryPerDay;
    private String role;
}
