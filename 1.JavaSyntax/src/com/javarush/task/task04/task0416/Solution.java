package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double currentTime = Double.parseDouble(reader.readLine()) % 5;
        if (currentTime<=3) System.out.println("зелёный");
        else if (currentTime<=4) System.out.println("жёлтый");
        else System.out.println("красный");


    }
}