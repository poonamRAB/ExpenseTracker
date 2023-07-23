package com.geekster.ExpenseTracker.controller;

import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    //adding product
    @PostMapping("product")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    //getting product list
    @GetMapping("product")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    //getting product by date
    @GetMapping("product/{date}")
    public List<Product> getProductByMonth(@PathVariable LocalDate date){
        return productService.getProductByMonth(date);
    }

    //getting prroduct by id
    @GetMapping("product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //updating product by id
    @PutMapping("product/{id}")
    public String updateProduct(@PathVariable Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    //deleting product by id
    @DeleteMapping("product/{id}")
    public String deleteProduct(@PathVariable Long id,@RequestBody Product product){
        return productService.deleteProduct(id,product);
    }
}
