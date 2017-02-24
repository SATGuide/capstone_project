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
    @GetMapping("/home")
    public String showingHomePage() {
        return "home";
    }

    @GetMapping("/transportation")
    public String howToGetTherePage() {
        return "transportation";
    }

    @GetMapping("/thingstodo")
    public String thingsToDoPage() {
        return "thingsToDo";
    }

    @GetMapping("/dining")
    public String whereToEatPage() {
        return "dining";
    }

    @GetMapping("/general")
    public String showGeneral() {
        return  "general";
    }

    @GetMapping("/localevents")
    public String localEventsPage() {
        return "localEvents";
    }

}
