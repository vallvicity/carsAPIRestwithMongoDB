package com.example.carsProject.controller;

import com.example.carsProject.entity.Person;
import com.example.carsProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    @Autowired
    PersonService personService = new PersonService();

    @RequestMapping("/createUser")
    public String createPerson(Model model) {
         model.addAttribute("person", new Person());

        return "newUserForm";
    }

    @RequestMapping("/addPerson")
    public String addPerson(@ModelAttribute Person person, Model model) {

        Person personCreated = personService.addPerson(person);
        model.addAttribute("person", personCreated);
        //TODO: add return template once you've created the person
        return "redirect:home";
    }
}
