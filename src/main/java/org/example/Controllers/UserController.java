package org.example.Controllers;

import enums.Priority;
import org.example.Services.UserService;
import org.example.TaskManager;
import org.example.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/signup_form")
    public String SignUpForm(Model model) {
        User newUser=new User();
        model.addAttribute("user",newUser);
        return "signup_form";

    }
    @PostMapping(path = "/users/register")
    public String saveNewUser(@ModelAttribute("user") User user) {
                UserService.newUser(user);

        return "redirect:/";
    }
    @GetMapping("/forgot_password")
    public String forgotPasswordForm(Model model) {
        return "forgot_password";

    }
}
