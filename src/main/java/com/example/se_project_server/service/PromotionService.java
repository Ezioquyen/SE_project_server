package com.example.se_project_server.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public interface PromotionService {
    void savePromotion(Map<String,Object> promotion);
    List<Map<String,Object>> getAllPromotion();
    Map<String,Object> getPromotionByDate(LocalDate date);
    Boolean checkPromotion(LocalDate start,Integer id);
    void deletePromotion(Integer id);
}
