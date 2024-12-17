package com.exemple.controller;

import com.exemple.model.User;
import com.exemple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, RedirectAttributes redirectAttributes) {
        // Check if the user exists by email
        User user = userRepository.findByEmail(email);
       
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/index";  
        } else {
          
            model.addAttribute("error", true); 
            return "login"; 
        }
    }
}
