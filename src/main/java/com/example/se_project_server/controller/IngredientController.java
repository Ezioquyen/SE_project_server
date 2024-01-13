package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Ingredient;
import com.example.se_project_server.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllIngredient(){
        return ResponseEntity.ok(ingredientService.getAllIngredient());
    }
    @PostMapping("/save")
    public void saveIngredient(@RequestBody Ingredient ingredient){
        System.out.println("add"+ingredient);
        ingredientService.setIngredient(ingredient);
    }
    @PutMapping("/update")
    public void updateIngredient(@RequestBody Ingredient ingredient){
        System.out.println("update"+ingredient);
        ingredientService.setIngredient(ingredient);
    }
    @DeleteMapping("/delete")
    public void deleteIngredient(@RequestBody String id){
        System.out.println("delete" + id);
        ingredientService.deleteIngredient(Integer.parseInt(id));
    }
}