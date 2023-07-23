package com.geekster.ExpenseTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private LocalDate purchaseDate;
    private String purchaseTime;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}
