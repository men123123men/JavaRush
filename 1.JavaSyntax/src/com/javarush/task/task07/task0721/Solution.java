package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] enteredInts = new int[20];

        int maximum=Integer.MIN_VALUE;
        int minimum=Integer.MAX_VALUE;

        for(int currentInt : enteredInts){
            currentInt = Integer.parseInt(reader.readLine());

            if (currentInt>maximum) maximum=currentInt;
            if (currentInt<minimum) minimum=currentInt;
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
