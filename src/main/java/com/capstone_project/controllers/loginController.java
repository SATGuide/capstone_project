package com.capstone_project.controllers;

import com.capstone_project.models.User;
import com.capstone_project.repositories.Merchants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nedwaldie on 2/23/17.
 */
@Controller
public class loginController {
    @Autowired
    Merchants merchantsRepo;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/profile")
    public String profilePage(Model model, User user) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("merchants", merchantsRepo.findByUserId(user.getId()));
        return "profile";
    }

    @GetMapping("/logout")
    public  String logoutpage() {
        return "redirect:/login?logout";
    }

}
