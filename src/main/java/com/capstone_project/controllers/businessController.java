package com.capstone_project.controllers;

import com.capstone_project.models.Category;
import com.capstone_project.models.Merchant;
import com.capstone_project.models.User;
import com.capstone_project.repositories.Categories;
import com.capstone_project.repositories.Merchants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nedwaldie on 2/22/17.
 */
@Controller
public class businessController {
    @Autowired
    Categories categoryRepo;

    @Autowired
    Merchants merchantRepo;

    @GetMapping("/merchant/add")
    public String newMerchant(Model model) {
        List<Category> categories = (List<Category>) categoryRepo.findAll();
        model.addAttribute("category", categories);
        model.addAttribute("merchant", new Merchant());
        return "/registration/business";
    }

    @PostMapping("/merchant/add")
    public String addNewMerchant(@Valid Merchant merchant) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        merchant.setUser(user);
        merchantRepo.save(merchant);
        return "redirect:/profile";
    }
}
