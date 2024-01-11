package com.example.se_project_server.entity;

import com.example.se_project_server.serializable.ProductPromotionId;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_promotion")
public class ProductPromotion {
    @EmbeddedId
    private ProductPromotionId id;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne
    @MapsId("promotionId")
    @JoinColumn(name="promotion_id")
    private Promotion promotion;
    private Double discount;

}
