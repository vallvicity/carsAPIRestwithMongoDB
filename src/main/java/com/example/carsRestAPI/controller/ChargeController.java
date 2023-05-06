package com.example.carsRestAPI.controller;


import com.example.carsRestAPI.model.Charge;
import com.example.carsRestAPI.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
public class ChargeController {

    @Autowired
    ChargeService chargeService;

    @GetMapping("/getCharges")
    public Iterable<Charge> getAllCharges() {

        return chargeService.getAllCharges();
    }

    @PostMapping("addCharge")
    public void chargeAdd(@RequestBody Charge charge) {

        chargeService.chargeAdd(charge);
    }

    @DeleteMapping("deleteCharge")
    public ResponseEntity<Charge> chargeDelete(@RequestParam int userId) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("operation", "deleteCharge");
        headers.add("version", "api 1.0");

        Charge chargeFound = chargeService.getChargeByUserId(userId);
        chargeService.chargeDelete(chargeFound);

        headers.add("operationStatus", "deleted");
        return ResponseEntity.accepted().headers(headers).body(chargeFound);
    }

    @PutMapping("updateCharge/{userId}")
    public ResponseEntity<Charge> chargeUpdate(@PathVariable("userId") int userId, @RequestBody Charge dataCharge) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("operation", "updateCharge");
        headers.add("version", "api 1.0");

        Charge chargeFound = chargeService.getChargeByUserId(userId);

        int index = chargeService.getIndexOfCharge(chargeFound);
        if (index == -1) {
            headers.add("operationStatus", "Charge Not Found");
        } else {

            chargeService.chargeUpdate(index, dataCharge);
            headers.add("operationStatus", "Updated!");
        }

        Charge updatedCharge = chargeService.getChargeByUserId(userId);

        return ResponseEntity.accepted().headers(headers).body(updatedCharge);
    }
}
