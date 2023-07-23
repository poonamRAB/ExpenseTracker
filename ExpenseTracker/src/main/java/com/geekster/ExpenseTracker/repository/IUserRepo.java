package com.geekster.ExpenseTracker.repository;

import com.geekster.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    User findByUser(User user);


    User findByUserEmail(String newEmail);

    User findByUser(String signInEmail);
}
