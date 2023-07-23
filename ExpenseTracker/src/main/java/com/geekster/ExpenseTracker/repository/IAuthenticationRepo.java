package com.geekster.ExpenseTracker.repository;

import com.geekster.ExpenseTracker.model.AuthenticationToken;
import com.geekster.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByUser(User user);
}
