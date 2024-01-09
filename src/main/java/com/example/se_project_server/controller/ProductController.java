package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Customer;
import com.example.se_project_server.entity.Product;
import com.example.se_project_server.service.ProductService;
import com.example.se_project_server.service.ProductServiceImp;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }
    @PostMapping("/save")
    public void saveProduct(@RequestBody String product){
        System.out.println("add"+product);
        JSONObject jsonObject = new JSONObject(product);
        Product product1 = new Product(jsonObject.getInt("id"),jsonObject.getString("name"),jsonObject.getInt("price"),jsonObject.getBoolean("available"),jsonObject.getDouble("discount"),jsonObject.getString("image"));
        productService.setProduct(product1);
//        return product;
    }
    @PutMapping("/update")
    public void updateProduct(@RequestBody String product){
        System.out.println("update"+product);
        JSONObject jsonObject = new JSONObject(product);
        Product product1 = new Product(jsonObject.getInt("id"),jsonObject.getString("name"),jsonObject.getInt("price"),jsonObject.getBoolean("available"),jsonObject.getDouble("discount"),jsonObject.getString("image"));
    }
    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody String id){
        System.out.println("delete" + id);
        productService.deleteProduct(Integer.parseInt(id));
    }
}