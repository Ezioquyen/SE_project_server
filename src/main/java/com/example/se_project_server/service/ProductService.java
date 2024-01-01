package com.example.se_project_server.service;
import com.example.se_project_server.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
     List<Product> getAllProduct();
}
