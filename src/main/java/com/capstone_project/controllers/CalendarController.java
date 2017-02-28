package com.capstone_project.controllers;

import com.capstone_project.models.Event;
import com.capstone_project.repositories.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by nedwaldie on 2/27/17.
 */
@Controller
public class CalendarController {
    @Autowired
    Events eventsRepo;

    @GetMapping("/events")
    public String calendarPage(Model model) {
        model.addAttribute("event", new Event());
        return "/registration/calendarform";
    }

    @PostMapping("/events")
    public String newCalendarEvent(@Valid Event event) {
        eventsRepo.save(event);
        return "redirect:/events";
    }
}
