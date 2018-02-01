package com.javarush.task.task15.task1522;

/*
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {

    }

    public static Planet thePlanet;
    static {
        readKeyFromConsoleAndInitPlanet();
    }
    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))) {
            thePlanet = Planet.getInstance(reader.readLine());
        } catch (IOException exc){
            exc.getStackTrace();
        }
    }
}
