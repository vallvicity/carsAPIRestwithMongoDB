package com.example.carsRestAPI.service;

import com.example.carsRestAPI.model.Charge;

import java.util.List;

public interface ChargeService {

    void chargeAdd(Charge charge);
    List<Charge> getAllCharges();
    void chargeDelete(Charge charge);
    void chargeUpdate(int index, Charge charge);
    Charge getChargeByUserId(int userId);
    int getIndexOfCharge(Charge charge);

}
