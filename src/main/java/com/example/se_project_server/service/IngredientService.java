package com.example.se_project_server.service;
import com.example.se_project_server.entity.Ingredient;
import com.example.se_project_server.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IngredientService {
    List<Ingredient> getAllIngredient();
    void setIngredient(Ingredient ingredient);
    void deleteIngredient(Integer id);
}
