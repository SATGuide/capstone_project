package com.capstone_project.controllers;

import com.capstone_project.models.Calendar;
import com.capstone_project.repositories.Calendars;
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
    Calendars calendarRepo;


    @GetMapping("/events")
    public String calendarPage(Model model) {
        model.addAttribute("calendar", new Calendar());
        return "calendarEvents";
    }

    @PostMapping("/events")
    public String newCalendarEvent(@Valid Calendar calendar) {
        calendarRepo.save(calendar);
        return "redirect:/calendar";
    }
}
