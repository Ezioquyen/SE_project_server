package com.example.se_project_server.service;

import com.example.se_project_server.entity.Ingredient;
import com.example.se_project_server.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.experimental.PackagePrivate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
        return ingredientRepository.findAllNotDeleted();
    }
    @Override
    public void setIngredient(Ingredient ingredient){
        System.out.println(ingredient);
        ingredientRepository.save(ingredient);
    }
    @Override
    public void deleteIngredient(Integer id){
//        ingredientRepository.deleteById(id);
        ingredientRepository.removeGroupById(id);
    }
}
