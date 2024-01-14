package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
    public Ingredient getById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update ingredient set is_removed = 1 WHERE id = :id", nativeQuery = true)
    void removeGroupById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "select * from ingredient where is_removed = false", nativeQuery = true)
    List<Ingredient> findAllNotDeleted();
}
