package com.example.se_project_server.repository;

import com.example.se_project_server.entity.ProductPromotion;
import com.example.se_project_server.serializable.ProductPromotionId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, ProductPromotionId> {
    @Query(value = """
    select product_id productId, discount from product_promotion
    """,nativeQuery = true)
    List<Map<String,Object>> getByPromotionId(Integer id);
    @Transactional
    @Modifying
    @Query(value = """
            delete from product_promotion where promotion_id =:id
            """,nativeQuery = true)
    void deleteAllById(@Param("id") Integer id);
}
