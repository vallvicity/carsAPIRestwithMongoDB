package com.example.carsRestAPI.repository;

import com.example.carsRestAPI.model.Charge;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ChargeRepository {

    private List<Charge> chargeList = new ArrayList<>();

    public void add(Charge charge) {

        chargeList.add(charge);
    }

    public List<Charge> getAllCharges() {
        //TODO: return what? the same 'chargeList'?
        //Or copy the List to another list and pass it...
        return chargeList;
    }

    public Charge getChargeByUserId(int userId) {

        Charge chargeFilter = chargeList.stream()
                            .filter(c -> c.getIdUser() == userId)
                            .findFirst()
                            .orElse(null);

        return chargeFilter;
    }

    public void chargeDelete(Charge charge) {

        chargeList.remove(charge);
    }

    public void updateCharge(int index, Charge charge) {

        chargeList.set(index, charge);
    }

    public int getIndexOfCharge(Charge charge) {
        for (int i = 0; i < chargeList.size(); i++) {
            if (charge.equals(chargeList.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
