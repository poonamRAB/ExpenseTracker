package com.geekster.ExpenseTracker.repository;

import com.geekster.ExpenseTracker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByProductDate(LocalDate date);
}
