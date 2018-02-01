package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static int increaseIfPositive(int value){
        return value>0? 1 : 0 ;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

//        int countOfPositive=0;
//        if (a>0) countOfPositive++;
//        if (b>0) countOfPositive++;
//        if (c>0) countOfPositive++;

        System.out.println(increaseIfPositive(a)+increaseIfPositive(b)+increaseIfPositive(c));

    }
}
