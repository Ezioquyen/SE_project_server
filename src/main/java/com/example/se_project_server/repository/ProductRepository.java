package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = """
            select id, name, price, available, image from product
            left outer join
            (select  SUM(bill_product.product_count) as totalCount, product_id from bill_product group by product_id) as filter
            on filter.product_id = product.id
            where product.is_deleted = false
            order by filter.totalCount desc
                        
            """, nativeQuery = true)
    List<Product> getAllProduct();

    @Query(value = """
            select p.id productId,  p.name,p.price,p.image,bp.product_count as count from product p
            join bill_product bp on p.id = bp.product_id
            where bp.bill_id = :orderBillId
            """, nativeQuery = true)
    List<Map<String, Object>> getProductByOrderBill(String orderBillId);


     Product getById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update product set is_deleted = 1 WHERE id = :id", nativeQuery = true)
    void removeGroupById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "select * from product where is_deleted = false", nativeQuery = true)
    List<Product> findAllNotDeleted();
}
