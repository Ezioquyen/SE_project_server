package com.example.se_project_server.service;

import com.example.se_project_server.entity.IBillProduct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface BillProductService {
    List<IBillProduct> getProductCount(LocalDateTime dateStart, LocalDateTime dateEnd);

    List<IBillProduct> getProfitPerDay(LocalDateTime dateStart, LocalDateTime dateEnd);

    List<IBillProduct> getProfitPerMonth(LocalDateTime dateStart, LocalDateTime dateEnd);
}
