package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Ingredient;
import com.example.se_project_server.service.IngredientService;
import com.example.se_project_server.service.IngredientServiceImp;
import org.json.JSONObject;
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
//        JSONObject jsonObject = new JSONObject(ingredient);
//        Ingredient ingredient1 = new Ingredient(jsonObject.getInt("id"), jsonObject.getString("name"), jsonObject.getInt("unit_Price"), jsonObject.getString("unit"));
        ingredientService.setIngredient(ingredient);
    }
    @DeleteMapping("/delete")
    public void deleteIngredient(@RequestBody String id){
        System.out.println("delete" + id);
        ingredientService.deleteIngredient(Integer.parseInt(id));
    }
}