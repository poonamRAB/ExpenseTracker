package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.Expense;
import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.repository.IExpenseRepo;
import com.geekster.ExpenseTracker.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    IExpenseRepo expenseRepo;

    @Autowired
    ProductService productService;


    public String addExpense(Expense expense) {
        expenseRepo.save(expense);
        return "new expense added successfully!!";
    }

    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    public String getExpensesByMonth(Integer month) {
        Long totalExpense = 0L;
        List<Product> productList = productService.getAllProduct();

        for(Product product : productList){
            if(product.getPurchaseDate().getMonth() == month){
                totalExpense += product.getPrice();
            }
        }

        return totalExpense.toString();
    }

    public String updateExpenseById(Long id, Expense expense) {
        expenseRepo.save(expense);
        return "Expense updates successfully!!";
    }

    public String DeleteExpense(Long id) {
        expenseRepo.deleteById(id);
        return "expense deleted successfully!!";
    }
}
