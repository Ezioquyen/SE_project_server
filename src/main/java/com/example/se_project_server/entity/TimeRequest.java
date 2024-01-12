package com.example.se_project_server.entity;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
@Component
public class TimeRequest {
    public LocalDate dateStart;

    public LocalDate dateEnd;

    public TimeRequest(){

    }
    public TimeRequest(LocalDate dateStart, LocalDate dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }
}
