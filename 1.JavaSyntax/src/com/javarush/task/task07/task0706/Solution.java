package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Улицы и дома
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] mass = new int[15];
        int sumodd = 0, sumeven = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mass.length; i++) {
            mass[i] = Integer.parseInt(reader.readLine());
            if ((i % 2 == 0)) {
                sumeven += mass[i];
            } else {
                sumodd += mass[i];
            }
        }
        if (sumeven > sumodd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}