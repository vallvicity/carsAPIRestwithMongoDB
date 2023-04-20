package com.example.carsRestAPI.service;


import com.example.carsRestAPI.model.Person;
import com.example.carsRestAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository = new PersonRepository();

    public Person getClientById(String id) {

        return personRepository.getClientByKey(id);
    }

    public Person updateClient(String id, Person person) {

        return personRepository.updateClient( id, person);
    }

    public void deleteClient(String id) {

        personRepository.deleteClient(id);
    }

    public Person addPerson(Person person) {
       return personRepository.addPerson(person);

    }

    public Collection<Person> getAll() {
        return personRepository.getAll();
    }
}

