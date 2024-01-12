package com.example.se_project_server.service;

import com.example.se_project_server.entity.Ingredient;
import com.example.se_project_server.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientServiceImp implements IngredientService{
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImp(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }
    @Override
    public void setIngredient(Ingredient ingredient){
        System.out.println(ingredient);
        ingredientRepository.save(ingredient);
    }
    @Override
    public void deleteIngredient(Integer id){
        ingredientRepository.deleteById(id);
    }
}
