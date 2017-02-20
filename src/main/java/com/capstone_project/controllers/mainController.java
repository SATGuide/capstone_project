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

    @GetMapping("/howtogetthere")
    public String howToGetTherePage() {return "howToGetThere"; }

    @GetMapping("/thingstodo")
    public String thingsToDoPage() {return "thingsToDo"; }

    @GetMapping("/whatishappening")
    public String whatIsHappeningPage() {return "whatIsHappening"; }

    @GetMapping("/wheretoeat")
    public String whereToEatPage() {return "whereToEat"; }
}
