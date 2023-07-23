package com.geekster.ExpenseTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Pattern(regexp = "^.+@(?![Hh][Oo][Ss][Pp][Aa][Dd][Mm][Ii][Nn]\\\\.[Cc][Oo][Mm]$).+$")
    private String email;

    @NotNull
    private String password;
    private String contactNumber;


}
