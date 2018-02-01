package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int age = Integer.parseInt(reader.readLine());

        int countOfDays = (age%4 !=0 || (age%400!=0 && age%100==0))? 365: 366;


        System.out.println("количество дней в году: "+countOfDays);


    }
}