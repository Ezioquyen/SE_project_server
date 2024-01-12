package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
     Ingredient getById(Integer id);
}
