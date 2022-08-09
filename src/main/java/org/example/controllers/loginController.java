package org.example.controllers;

import org.example.TaskManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/signup_form")
    public String SignUpForm(Model model) {
        return "signup_form";

    }
}
