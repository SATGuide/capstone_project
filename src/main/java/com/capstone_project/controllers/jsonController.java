package com.capstone_project.controllers;

import com.capstone_project.models.Merchant;
import com.capstone_project.repositories.Merchants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nedwaldie on 2/28/17.
 */
@Controller
public class jsonController {
    @Autowired
    Merchants merchantRepo;

    @GetMapping("/merchants/{categoryId}/list.json")
    public @ResponseBody List<Merchant> merchantList(@PathVariable int categoryId) {
        return merchantRepo.findByCategory(categoryId);
    }
}
