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
    @GetMapping("/showhome/{name}")
    public String showingHomePage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "showHome";
    }

    @GetMapping("/howtogetthere/{name}")
    public String howToGetTherePage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "howToGetThere";
    }

    @GetMapping("/thingstodo/{name}")
    public String thingsToDoPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "thingsToDo";
    }

    @GetMapping("/whatishappening/{name}")
    public String whatIsHappeningPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "whatIsHappening";
    }

    @GetMapping("/wheretoeat/{name}")
    public String whereToEatPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "whereToEat";
    }
}
