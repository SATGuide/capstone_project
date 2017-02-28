package com.capstone_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nedwaldie on 2/23/17.
 */
@Controller
public class loginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
