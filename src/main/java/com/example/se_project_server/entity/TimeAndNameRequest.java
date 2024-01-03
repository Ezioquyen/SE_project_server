package com.example.se_project_server.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class TimeAndNameRequest {
    public String stringSearch;
    public LocalDate dateStart;

    public LocalDate dateEnd;

    public TimeAndNameRequest(){

    }
    public TimeAndNameRequest(String stringSearch, LocalDate dateStart, LocalDate dateEnd) {
        this.stringSearch = stringSearch;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getStringSearch() {
        return stringSearch;
    }

    public void setStringSearch(String stringSearch) {
        this.stringSearch = stringSearch;
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
