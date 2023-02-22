package com.first.firstspringbootproject;

import com.first.firstspringbootproject.user.User;
import com.first.firstspringbootproject.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@Controller
public class AppController {
    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/index")
    private String index() {
        return "index";
    }

    @GetMapping("/externalRedirect")
    public String handleExternalRedirect(@RequestParam("source") String source) {
        // Handle the source parameter here
        return "redirect:/registerPlayer";
    }
    @GetMapping("/loginUser")
    public String loginUser(Model model) {
        model.addAttribute("signUpForm", new User());
        return "login";
    }
    @GetMapping("/processLogin")
    public String processLogin(Model model) {
        model.addAttribute("signUpForm", new User());
        return "loginSuccess";
    }

    @GetMapping("/registerUser")
    public String registerUser(Model model) {
        model.addAttribute("signUpForm", new User());
        model.addAttribute("message", "");
        return "signupForm";
    }
    @PostMapping("/processRegister")
    public String processRegister(User user, Model model) throws ExecutionException, InterruptedException {
        Integer status = userService.userExists(user);
        if ( status == 1) {
            user.setUsername("");
            model.addAttribute("signUpForm", user);
            model.addAttribute("message", "Username exists! Try another one");
            return "signupForm";

        }else if (status == 2) {
            user.setEmail("");
            model.addAttribute("signUpForm", user);
            model.addAttribute("message", "E-mail exists! Try another one");
            return "signupForm";
        }else{
            userService.saveUser(user);
            return "registerSuccess";
        }
    }
    @GetMapping("/signupForm")
    public String signupForm(Model model) {
        model.addAttribute("signUpForm", new User());
        return "signupForm";
    }

}
