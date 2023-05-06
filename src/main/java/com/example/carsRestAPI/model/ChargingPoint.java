package com.example.carsRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargingPoint {
    private String id;
    private String address;
    private String connectorType;
    private String state;

}
