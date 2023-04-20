package com.example.carsRestAPI.Utils;

import java.util.UUID;

public class Utils {

    public static String createUUID() {

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }
}
