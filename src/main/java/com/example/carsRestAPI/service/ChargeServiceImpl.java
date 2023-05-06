package com.example.carsRestAPI.service;

import com.example.carsRestAPI.model.Charge;
import com.example.carsRestAPI.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    public void chargeAdd(Charge charge) {

        chargeRepository.add(charge);
    }

    public List<Charge> getAllCharges() {

      return chargeRepository.getAllCharges();
    }

    public void chargeDelete(Charge charge) {

        chargeRepository.chargeDelete(charge);
    }

    public void chargeUpdate(int index, Charge charge) {

        chargeRepository.updateCharge(index, charge);
    }

    public Charge getChargeByUserId(int userId) {

        Charge chargeFound = chargeRepository.getChargeByUserId(userId);

        return chargeFound;
    }

    public int getIndexOfCharge(Charge charge) {
        return chargeRepository.getIndexOfCharge(charge);
    }
}
