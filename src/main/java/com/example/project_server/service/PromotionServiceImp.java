package com.example.se_project_server.service;

import com.example.se_project_server.entity.Product;
import com.example.se_project_server.entity.ProductPromotion;
import com.example.se_project_server.entity.Promotion;
import com.example.se_project_server.repository.ProductPromotionRepository;
import com.example.se_project_server.repository.PromotionRepository;
import com.example.se_project_server.serializable.ProductPromotionId;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PromotionServiceImp implements PromotionService {
    private final PromotionRepository promotionRepository;
    private final ProductPromotionRepository productPromotionRepository;

    public PromotionServiceImp(PromotionRepository promotionRepository, ProductPromotionRepository productPromotionRepository) {
        this.promotionRepository = promotionRepository;
        this.productPromotionRepository = productPromotionRepository;
    }

    @Override
    public void savePromotion(Map<String, Object> data) {
        Promotion promotion = new Promotion();
        promotion.setId((Integer) data.get("id"));
        promotion.setName(data.get("name").toString());
        promotion.setInformation(data.get("information").toString());
        promotion.setNeedCondition((Boolean) data.get("condition"));
        promotion.setStartDate(LocalDate.parse(data.get("startDate").toString(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        promotion.setEndDate(LocalDate.parse(data.get("endDate").toString(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        promotionRepository.save(promotion);
        for (Map<String, Object> product : (List<Map<String, Object>>) data.get("products")) {
            ProductPromotion productPromotion = new ProductPromotion();
            ProductPromotionId productPromotionId = new ProductPromotionId();
            productPromotionId.setProductId((Integer) product.get("productId"));
            productPromotionId.setPromotionId((Integer) data.get("id"));
            productPromotion.setId(productPromotionId);
            Product product1 = new Product();
            product1.setId((Integer) product.get("productId"));
            productPromotion.setProduct(product1);
            productPromotion.setPromotion(promotion);
            productPromotion.setDiscount(Double.parseDouble(product.get("discount").toString()));
            productPromotionRepository.save(productPromotion);
        }
    }

    @Override
    public List<Map<String, Object>> getAllPromotion() {return promotionRepository.getAll().parallelStream().map(HashMap::new).peek(promotion -> promotion.put("products", productPromotionRepository.getByPromotionId((Integer) promotion.get("id")))).collect(Collectors.toList());}


    @Override
    public Map<String, Object> getPromotionByDate(LocalDate date) {
        Map<String, Object> promotion = new HashMap<>(promotionRepository.getPromotionByDate(date.toString()));
        promotion.put("products", productPromotionRepository.getByPromotionId((Integer) promotion.get("id")));
        return promotion;
    }

    @Override
    public Boolean checkPromotion(LocalDate start,Integer id) {
         if(promotionRepository.checkPromotion(start.toString(),id)==null)return true;
         else return promotionRepository.checkPromotion(start.toString(),id);
    }

    @Override
    public void deletePromotion(Integer id) {
        productPromotionRepository.deleteAllById(id);
        promotionRepository.deleteById(id);
    }
}
