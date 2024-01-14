package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Ingredient;
import com.example.se_project_server.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product getById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update product set is_removed = 1 WHERE id = :id", nativeQuery = true)
    void removeGroupById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "select * from product where is_removed = false", nativeQuery = true)
    List<Product> findAllNotDeleted();
}
