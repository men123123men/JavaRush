package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String userEnter;
        while (!(userEnter = reader.readLine()).equals("exit")){

            if (userEnter.matches("-?\\d+\\.\\d+") || userEnter.matches("-?\\d+")) {
                if (userEnter.contains("."))
                    print(Double.parseDouble(userEnter));
                else if (Integer.parseInt(userEnter) > 0 && Integer.parseInt(userEnter) < 128 )
                    print(Short.parseShort(userEnter));
                else
                    print(Integer.parseInt(userEnter));
            } else print(userEnter);
        }
    }
    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }
    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }
    public static void print(short value)  { System.out.println("Это тип short, значение " + value); }
    public static void print(Integer value){ System.out.println("Это тип Integer, значение " + value); }
}
