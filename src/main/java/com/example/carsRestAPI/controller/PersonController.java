package com.example.carsRestAPI.controller;

import com.example.carsRestAPI.model.Person;
import com.example.carsRestAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PersonController {
    @Autowired
    PersonService personService = new PersonService();

    @PostMapping(value = "/addPerson", consumes = "application/json")
    public Person addPerson(@RequestBody Person person) {

        Person personCreated = personService.addPerson(person);

        return personCreated;
    }

    @GetMapping("/filledUserForm")
    public ResponseEntity<Person> returnUserForm(@RequestParam("idFromView") String id){

        HttpHeaders headers= new HttpHeaders();

        Person person = personService.getClientById(id);
        if(person != null) {
            headers.add("operation", "detailUser");
            headers.add("version", "api 1.0");
            return ResponseEntity.accepted().headers(headers).body(person);
        }

        headers.add("operationStatus", "User not Found");
        return ResponseEntity.accepted().headers(headers).body(null);


    }

    @DeleteMapping("deleteUser")
    public ResponseEntity<Person> deleteUser(@RequestParam("idFromView") String id) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("operation", "deleteUser");
        headers.add("version", "api 1.0");

        Person personFound = personService.getClientById(id);

        headers.add("operationStatus", "deleted");
        personService.deleteClient(id);
        return ResponseEntity.accepted().headers(headers).body(personFound);
    }

    @RequestMapping("/getUserFormToUpdate")
    public String personUpdate(@RequestParam("idFromView") String id, Model model) {

        Person personFound = personService.getClientById(id);

        if(personFound != null){
            model.addAttribute("userIdFromView", id);
            model.addAttribute("person", personFound);
            model.addAttribute("message", "User Found.");
        } else {
            model.addAttribute("message", "User not found");
        }

        return "userToUpdate";
    }

    @PutMapping("/userUpdate/{userIdFromView}")
    public Person userUpdateSubmit(@PathVariable("userIdFromView") String id, @RequestBody Person person) {

        Person personFound = personService.updateClient(id, person);

        return personFound;
    }

}
