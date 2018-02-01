package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> citySurnames =new HashMap<>();

        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String surnames = reader.readLine();
            citySurnames.put(city,surnames);
        }

        String userEnter = reader.readLine();

        if (citySurnames.containsKey(userEnter))
            System.out.println(citySurnames.get(userEnter));

    }
}
