package com.capstone_project.controllers;

import com.capstone_project.models.User;
import com.capstone_project.models.UserRole;
import com.capstone_project.repositories.Merchants;
import com.capstone_project.repositories.Roles;
import com.capstone_project.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class registrationController {
    @Autowired
    Users userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    Roles roles;

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, Errors validation, Model model, @RequestParam(name = "confirm-password") String passwordconfirmation) {

        if (!passwordconfirmation.equals(user.getPassword())) {
            validation.rejectValue("password", "user.password", "Your passwords do not match");
        }
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "registration";
        }

        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        User newUser = userRepo.save(user);

        UserRole ur = new UserRole();
        ur.setRole("ROLE_USER");
        ur.setUserId(newUser.getId());
        roles.save(ur);

        return "redirect:/login";
    }


}
