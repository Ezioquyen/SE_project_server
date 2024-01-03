package com.example.se_project_server.service;

import com.example.se_project_server.entity.IBillProduct;
import com.example.se_project_server.entity.ISalaryCal;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface SalaryCalService {
    List<ISalaryCal> getAllSalaryCal(LocalDate dateStart, LocalDate dateEnd);

    List<ISalaryCal> getSalaryBySearching(String stringSearch, LocalDate dateStart, LocalDate dateEnd);

    List<IBillProduct> getSalaryPerDay(LocalDate dateStart, LocalDate dateEnd);

    List<IBillProduct> getSalaryPerMonth(LocalDate dateStart, LocalDate dateEnd);
}
