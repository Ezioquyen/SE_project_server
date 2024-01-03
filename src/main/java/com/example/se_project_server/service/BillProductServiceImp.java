package com.example.se_project_server.service;

import com.example.se_project_server.entity.IBillProduct;
import com.example.se_project_server.repository.OrderBillRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Component
public class BillProductServiceImp implements  BillProductService{

    private final OrderBillRepository orderBillRepo;

    public BillProductServiceImp(OrderBillRepository orderBillRepo) {
        this.orderBillRepo = orderBillRepo;
    }


    @Override
    public List<IBillProduct> getProductCount(LocalDateTime dateStart, LocalDateTime dateEnd) {
        return orderBillRepo.getProductCount(dateStart, dateEnd);
    }

    @Override
    public List<IBillProduct> getProfitPerDay(LocalDateTime dateStart, LocalDateTime dateEnd) {
        return orderBillRepo.getProfitPerDay(dateStart, dateEnd);
    }

    @Override
    public List<IBillProduct> getProfitPerMonth(LocalDateTime dateStart, LocalDateTime dateEnd) {
        return orderBillRepo.getProfitPerMonth(dateStart, dateEnd);
    }
}
