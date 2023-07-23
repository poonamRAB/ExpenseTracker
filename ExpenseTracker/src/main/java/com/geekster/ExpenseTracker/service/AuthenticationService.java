package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.AuthenticationToken;
import com.geekster.ExpenseTracker.model.User;
import com.geekster.ExpenseTracker.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authenticationRepo;

    public String saveToken(User user){
        AuthenticationToken token = new AuthenticationToken(user);
        authenticationRepo.save(token);
        return token.getTokenValue();
    }

    public AuthenticationToken getTokenByUser (User user){
        return authenticationRepo.findByUser(user);
    }

    public void removeToken(AuthenticationToken token){
        authenticationRepo.delete(token);
    }


}
