package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }
    public static Flyable result;

    static {
        //add your code here - добавьте код тут
        reset();
        System.out.println(result);
    }


    public static void reset() {
        //add your code here - добавьте код тут
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader (input);
        try{
            String userChoice = reader.readLine();

            switch (userChoice){
                case "helicopter" : result = new Helicopter(); break;
                case "plane"      : result = new Plane(Integer.parseInt(reader.readLine())); break;
            }
            input.close();
            reader.close();

        } catch (IOException exc){
            exc.getStackTrace();
        }


    }
}
