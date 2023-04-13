package com.example.carsProject.controller;

import com.example.carsProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    PersonService personService;

    @RequestMapping("/home")
    public String getHome(Model model) {

        model.addAttribute("todayDate", new Date().toString());
        model.addAttribute("persons", personService.getAll());
        return "home";
    }
}
