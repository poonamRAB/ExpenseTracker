package com.geekster.ExpenseTracker.controller;

import com.geekster.ExpenseTracker.model.Expense;
import com.geekster.ExpenseTracker.model.User;
import com.geekster.ExpenseTracker.model.dto.SignInInput;
import com.geekster.ExpenseTracker.model.dto.SignUpOutput;
import com.geekster.ExpenseTracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    //user sign up
    @PostMapping("user/signUp")
    public SignUpOutput signUp(@RequestBody @Valid User user){
        return userService.signUp(user);
    }

    //user signIn
    @PostMapping("user/signIn")
    public String signIn(@RequestBody @Valid SignInInput signInInput){
        return userService.signIn(signInInput);
    }


    //deleting sign out user
    @DeleteMapping("signOut")
    public String DeleteSignOutUser( @RequestParam String email){
        return userService.DeleteSignOutUser(email);
    }


}
