package com.example.carsRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person{

    //TODO: Now vehicle is a String
    //But should it be an object?
    private String vehicle;
}
