package com.example.carsProject.Utils;

import java.util.UUID;

public class Utils {

    public static String createUUID() {

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }
}
