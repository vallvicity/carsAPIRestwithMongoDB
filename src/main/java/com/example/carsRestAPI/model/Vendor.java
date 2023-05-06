package com.example.carsRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor extends Person{

    //TODO: Now 'chargingPoint' is a string
    //Should it be an Object?
    private ChargingPoint chargingPoint;
}
