package com.example.se_project_server.service;

import com.example.se_project_server.entity.IBillIngredient;
import com.example.se_project_server.entity.IBillProduct;
import com.example.se_project_server.repository.BuyIngredientBillRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class BillIngredientServiceImp implements  BillIngredientService{
    private  final BuyIngredientBillRepository buyIngredientBillRepo;

    public BillIngredientServiceImp(BuyIngredientBillRepository buyIngredientBillRepo) {
        System.out.println("ERROR");
        this.buyIngredientBillRepo = buyIngredientBillRepo;
    }


    @Override
    public List<IBillIngredient> getIngredientCount(LocalDate dateStart, LocalDate dateEnd) {
        return buyIngredientBillRepo.getIngredientCount(dateStart, dateEnd);
    }

    @Override
    public List<IBillProduct> getBIPerDay(LocalDate dateStart, LocalDate dateEnd) {
        return buyIngredientBillRepo.getBIPerDay(dateStart, dateEnd);
    }

    @Override
    public List<IBillProduct> getBIPerMonth(LocalDate dateStart, LocalDate dateEnd) {
        return buyIngredientBillRepo.getBIPerMonth(dateStart, dateEnd);
    }
}
