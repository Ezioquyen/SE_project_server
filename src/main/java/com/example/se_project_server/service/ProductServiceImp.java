package com.example.se_project_server.service;

import com.example.se_project_server.entity.Product;
import com.example.se_project_server.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }
    @Override
    public void setProduct(Product product) {
        System.out.println(product);
        productRepository.save(product);
    }
    @Override
    public void deleteProduct(Integer id) {
        productRepository.removeGroupById(id);
    }
}
