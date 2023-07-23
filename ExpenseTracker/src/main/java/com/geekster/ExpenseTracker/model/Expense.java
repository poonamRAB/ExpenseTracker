package com.geekster.ExpenseTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "fk_expense_id")
    private List<Product> productList;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}
