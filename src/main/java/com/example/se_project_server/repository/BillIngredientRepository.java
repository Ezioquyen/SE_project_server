package com.example.se_project_server.repository;

import com.example.se_project_server.entity.BillIngredient;
import com.example.se_project_server.serializable.BillIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillIngredientRepository extends JpaRepository<BillIngredient, BillIngredientId> {
}
