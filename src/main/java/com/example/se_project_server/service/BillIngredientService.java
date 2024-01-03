package com.example.se_project_server.service;

import com.example.se_project_server.entity.IBillIngredient;
import com.example.se_project_server.entity.IBillProduct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface BillIngredientService {
    List<IBillIngredient> getIngredientCount(LocalDate dateStart, LocalDate dateEnd);

    List<IBillProduct> getBIPerDay(LocalDate dateStart, LocalDate dateEnd);

    List<IBillProduct> getBIPerMonth(LocalDate dateStart, LocalDate dateEnd);
}
