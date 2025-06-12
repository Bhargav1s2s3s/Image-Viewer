package com.example.springHtml.Service;

import com.example.springHtml.Model.UserModel;
import com.example.springHtml.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userData;

    public String checkMailAndPassword(String email, String password) {
        String pass = userData.getPasswordByEmail(email).toString();
        if(pass != null && password.equals(pass)) {
            System.out.println("Ok Working");
            return "ok";
        }
        System.out.println("failed");
        return "failed";

    }
}
