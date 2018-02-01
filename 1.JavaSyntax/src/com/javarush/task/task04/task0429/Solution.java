package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        consider(Integer.parseInt(reader.readLine()));
        consider(Integer.parseInt(reader.readLine()));
        consider(Integer.parseInt(reader.readLine()));

        System.out.println("количество положительных чисел: "+countOfPositive);
        System.out.println("количество отрицательных чисел: "+countOfNegative);
    }
    public static int countOfPositive;
    public static int countOfNegative;

    public static void consider(int value){
        if (value<0) countOfNegative++;
        if (value>0) countOfPositive++;
    }
}
