package com.capstone_project.controllers;

import com.capstone_project.models.User;
import com.capstone_project.repositories.Merchants;
import com.capstone_project.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by nedwaldie on 2/23/17.
 */
@Controller
public class loginController {
    @Autowired
    Merchants merchantsRepo;

    @Autowired
    Users usersrepo;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/profile")
    public String profilePage(Model model, User user) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("company", user.getCompany());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("merchants", merchantsRepo.findByUserId(user.getId()));
        return "profile";
    }

    @GetMapping("/logout")
    public  String logoutpage() {
        return "redirect:/login?logout";
    }

    @GetMapping("/profile/{id}/edit")
    public String editProfilePage(Model model, @PathVariable int id) {
        model.addAttribute("user", usersrepo.findOne(id));
        return "edit-profile";
    }

    @PostMapping("/profile/{id}/edit")
    public String editProfile(@ModelAttribute User user, Model model) {
        usersrepo.save(user);
        return "redirect:/profile";
    }
}
