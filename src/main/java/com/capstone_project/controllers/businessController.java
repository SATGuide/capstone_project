package com.capstone_project.controllers;

import com.capstone_project.models.Merchant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nedwaldie on 2/22/17.
 */
@Controller
public class businessController {
    @GetMapping(name = "/merchant/add")
    public String newMerchant(Model model) {
        model.addAttribute("merchant", new Merchant());
        return "/registration/business";
    }
}
