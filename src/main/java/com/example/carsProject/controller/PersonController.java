package com.example.carsProject.controller;

import com.example.carsProject.entity.Person;
import com.example.carsProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "redirect:home";
    }

    @RequestMapping("/filledUserForm")
    public String returnUserForm(@RequestParam("idFromView") String id, Model model){
        Person person = personService.getClientByKey(id);
        model.addAttribute("person", person);
        return "filledUserForm";

    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("idFromView") String id) {
        personService.deleteClient(id);
        return "redirect:home";
    }

    @RequestMapping("/getUserFormToUpdate")
    public String personUpdate(@RequestParam("idFromView") String id, Model model) {

        Person personFound = personService.getClientByKey(id);

        if(personFound != null){
            model.addAttribute("userIdFromView", id);
            model.addAttribute("person", personFound);
            model.addAttribute("message", "User Found.");
        } else {
            model.addAttribute("message", "User not found");
        }

        return "userToUpdate";
    }

    @PostMapping("/userUpdate/{userIdFromView}")
    public String userUpdateSubmit(@PathVariable("userIdFromView") String id, Person person) {

        personService.updateClient(id, person);

        return "redirect:/home";
    }

}
