package com.example.springHtml.Service;

import com.example.springHtml.Model.ImageUploader;
import com.example.springHtml.Model.UserModel;
import com.example.springHtml.Repository.ImageRepo;
import com.example.springHtml.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userData;

    @Autowired
    ImageRepo img;

    public String checkMailAndPassword(String email, String password) {
        String pass = userData.getPasswordByEmail(email).toString();
        UserModel user = userData.getByEmail(email);
        if(pass != null && user.getPassword().toString().equals(password)) {
            System.out.println("Ok Working");
            return user.getFname().toString();
        }
        System.out.println("failed");
        return "failed";
    }


    public String addUrl(String email, String url) {
        ImageUploader imhUrl = new ImageUploader(email, url);
        boolean existed = userData.checkMailExistedorNot(email);

        if(existed) {
            img.save(imhUrl);
            System.out.println("image uploaded");
            return "Uploaded";
        }
        System.out.println("not uploaded");
        return "failed";}

    public UserModel getAllByEmail(String email) {
        //UserModel EntireUserCerd = userData.getByEmail(email);
        return userData.getByEmail(email);
    }
}
