package com.example.springHtml.Controller;

import com.example.springHtml.Model.UserModel;
import com.example.springHtml.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepo usRepo;

    @GetMapping("/getallUser")
    public String getAllUser(Model model) {
        List<UserModel> users = usRepo.findAll();
        model.addAttribute("users",users);
        return "registeredUsersList";
    }
}
