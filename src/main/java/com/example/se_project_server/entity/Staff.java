package com.example.se_project_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Timekeeping> timekeepings;
}
