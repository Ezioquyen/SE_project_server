package com.example.se_project_server.serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class TimekeepingId implements Serializable {
    @Column(name = "staff_id")
    String staffId;
    @Column(name="work_date")
    LocalDate workDate;
}
