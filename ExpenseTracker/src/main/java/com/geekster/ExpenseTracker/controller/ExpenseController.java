package com.geekster.ExpenseTracker.controller;

import com.geekster.ExpenseTracker.model.Expense;
import com.geekster.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    //adding expenses
    @PostMapping("expense")
    public String addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }
    //getting all expenses
    @GetMapping("expense")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    //getting expenses by month
    @GetMapping("expense/{month}")
    public String getExpensesByMonth(@PathVariable Integer month){
        return expenseService.getExpensesByMonth(month);
    }
    //update expense by id
    @PutMapping("expense/{id}")
    public String updateExpenseById(@PathVariable Long id,@RequestBody Expense expense){
        return expenseService.updateExpenseById(id,expense);
    }

    //deleting expense by id
    @DeleteMapping("expense/{id")
    public String deleteExpense(@PathVariable Long id){
        return expenseService.DeleteExpense(id);
    }

}
