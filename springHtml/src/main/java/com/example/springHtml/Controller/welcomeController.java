package com.example.springHtml.Controller;

import com.example.springHtml.Model.UserModel;
import com.example.springHtml.Repository.UserRepo;
import com.example.springHtml.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/main")
public class welcomeController {

    @Autowired
    private UserRepo usRep;

    @Autowired
    UserService service;

    @GetMapping("/home")
    public String Greet() {
            return "welcome";
        }

    @GetMapping("/access")
    public String AccessContentPage() {
        return "ContentAccess";
    }

    @PostMapping("/home")
    public ModelAndView SignIn(@RequestParam String email, @RequestParam String password){
        String res = service.checkMailAndPassword(email, password);
        if(res.equals("ok")) {
            System.out.println("Content primited");
            return new ModelAndView("redirect:/main/access");
        }

        System.out.println("Content not Primited");
        return new ModelAndView("redirect:/main/signup");
    }



    @GetMapping("/signup")
    private String SignUpPage() {
        System.out.println("signUP test");
        return "signupPage";
    }

    @PostMapping("/signup")
    public String SignUpData(@RequestParam String fname,
                             @RequestParam String lname,
                             @RequestParam String email,
                             @RequestParam String password,
                             Model model) {
        UserModel user = new UserModel(fname,lname,email,password);
        usRep.save(user);
        model.addAttribute("userFirstName",fname);
        System.out.println("signUP adding test");
        return "welcomeGreetsPage";

    }
}

