package com.example.carsRestAPI.controller;

import com.example.carsRestAPI.model.Person;
import com.example.carsRestAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/home")
public class HomeController {

    @Autowired
    PersonService personService;

    @GetMapping("/home")
    public Iterable<Person> getAllPersons() {

        return personService.getAll();
    }
}
