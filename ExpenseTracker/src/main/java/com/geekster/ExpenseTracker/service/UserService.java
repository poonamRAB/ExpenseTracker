package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.AuthenticationToken;
import com.geekster.ExpenseTracker.model.User;
import com.geekster.ExpenseTracker.model.dto.SignInInput;
import com.geekster.ExpenseTracker.model.dto.SignUpOutput;
import com.geekster.ExpenseTracker.repository.IUserRepo;
import com.geekster.ExpenseTracker.service.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired

    AuthenticationService authenticationService;





    public String DeleteSignOutUser(String email) {
        User user = userRepo.findByUser(user);
        AuthenticationToken token = authenticationService.getTokenByUser(user);
        authenticationService.removeToken(token);
        return "User Signed out successfully";
    }


    public SignUpOutput signUp(User user) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        User existingUser = userRepo.findByUserEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getPassword());


            user.setPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String signIn(SignInInput signInInput) {
        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        User existingUser = userRepo.findByUser(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getPassword().equals(encryptedPassword))
            {
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authenticationService.saveToken(authToken.getUser());

            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
        return "";
    }
}
