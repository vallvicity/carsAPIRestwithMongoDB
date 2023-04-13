package com.example.carsProject.service;

import com.example.carsProject.Utils.Utils;
import com.example.carsProject.entity.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class PersonService {

    private HashMap<String, Person> clientList = new HashMap<>();

    public Person getClientByKey(String key) {

        return clientList.get(key);
    }

    public void updateClient(String id, Person person) {

        clientList.put( id, person);
    }

    public void deleteClient(String id) {

        clientList.remove(id);
    }

    public Person addPerson(Person person) {
        Person newPerson = new Person();

        newPerson.setName(person.getName());
        newPerson.setUsername(person.getUsername());
        newPerson.setDocumentId(person.getDocumentId());
        newPerson.setAddress(person.getAddress());

        String newId = Utils.createUUID();
        newPerson.setId(newId);

        clientList.put(newPerson.getId(), newPerson);
        return newPerson;

    }

    public Collection<Person> getAll() {
        return clientList.values();
    }
}

