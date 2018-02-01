package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> userEnter = new HashMap<>();

        while(true) {
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            if (name.equals("")) break;
            userEnter.put(name, id);
        }



        for(Map.Entry<String ,Integer> pair: userEnter.entrySet())
        System.out.println(pair.getKey() + " " + pair.getValue());










    }
}
