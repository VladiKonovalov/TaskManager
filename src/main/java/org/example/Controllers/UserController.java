package org.example.Controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.Repository.UserRepository;
import org.example.Services.UserService;
import org.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;
    private UserRepository userRepository;

    //private PasswordEncoder passwordEncoder;
    // @Autowired
    public UserController(UserService userService, UserRepository userRepository
                          //, PasswordEncoder passwordEncoder
    ) {
        this.userService = userService;
        this.userRepository = userRepository;
        //     this.passwordEncoder = passwordEncoder;
    }


//    @RequestMapping("/")
//    public String index() {
//        return "login";
//    }
@GetMapping("/login")
public String loginPage() {
    return "login";
}
    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String email, @RequestParam("password") String password, Model model) {
            return "redirect:/tasks";
    }

    @GetMapping("/signup_form")
    public String SignUpForm(Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "signup_form";

    }

    @PostMapping(path = "/users/register")
    public String saveNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        this.userService.newUser(user);
        return "redirect:/";
    }

    @GetMapping("/forgot_password")
    public String forgotPasswordForm(Model model) {
        return "forgot_password";

    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

//}
