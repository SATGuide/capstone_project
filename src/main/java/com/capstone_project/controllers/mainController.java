package com.capstone_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by nedwaldie on 2/17/17.
 */
@Controller
public class mainController {
    @GetMapping("/home/{name}")
    public String homePage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "Home";
    }

    @GetMapping("/transportation/{name}")
    public String transportationPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "transportation";
    }

    @GetMapping("/thingstodo/{name}")
    public String thingsToDoPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "thingsToDo";
    }

    @GetMapping("/localevents/{name}")
    public String localEventsPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "local events";
    }

    @GetMapping("/dining/{name}")
    public String diningPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "dining";
    }
}
