package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo productRepo;

    public String addProduct(Product product) {
        productRepo.save(product);
        return "new product added successfully!!";
    }

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public List<Product> getProductByMonth(LocalDate date) {
        List<Product> productList = productRepo.findByProductDate(date);
        return productList;
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public String updateProduct(Long id, Product product) {
        productRepo.save(product);
        return "product updated successfully!!";
    }

    public String deleteProduct(Long id, Product product) {
        productRepo.deleteById(id);
        return "product deleted successfully!!";
    }
}
