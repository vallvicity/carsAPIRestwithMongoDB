package com.example.carsRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private String name;
    private String username;
    private String password;
    private Boolean compliance;
    private String documentId;
    private String id;
    private String address;

    public boolean equals(Object o) {

        if(this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person compared = (Person) o;

        if (this.name.equals(compared.name) && this.username.equals(compared.username)
                && this.password.equals(compared.password) && this.compliance == compared.compliance
                && this.documentId.equals(compared.documentId) && this.id == compared.id
                && this.address.equals(compared.address)) {
            return true;
        }

        return false;
    }

}