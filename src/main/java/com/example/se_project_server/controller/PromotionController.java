package com.example.se_project_server.controller;


import com.example.se_project_server.service.PromotionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
    @PutMapping("/save")
    public void savePromotion(@RequestBody Map<String,Object> promotion){
        promotionService.savePromotion(promotion);
    }
    @GetMapping("/getPromotions")
    public ResponseEntity<?> getAllPromotion(){
        return  ResponseEntity.ok(promotionService.getAllPromotion());
    }
    @GetMapping("/getPromotion")
    public ResponseEntity<?> getPromotionByDate(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return  ResponseEntity.ok(promotionService.getPromotionByDate(date));
    }
    @GetMapping("/check/{id}")
    public boolean checkPromotion(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,@PathVariable("id")Integer id){
        return promotionService.checkPromotion(start,id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
        promotionService.deletePromotion(id);
    }
}
