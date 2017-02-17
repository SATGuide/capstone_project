package com.capstone_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nedwaldie on 2/17/17.
 */
@Controller
public class mainController {
    @GetMapping("/home")
    public String showingHomePage() {
        return "index";
    }
}
