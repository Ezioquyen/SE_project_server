package com.example.se_project_server.serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProductPromotionId implements Serializable {
    @Column(name = "promotion_id")
    private Integer promotionId;
    @Column(name = "product_id")
    private Integer productId;
}
