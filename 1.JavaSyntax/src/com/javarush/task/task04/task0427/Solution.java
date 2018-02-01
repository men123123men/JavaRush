package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        String  prticl = a%2!=0 ? "не": "";

        String countOfDidits;
        if (a<10) countOfDidits = "одно";
        else if (a<100) countOfDidits = "дву";
        else countOfDidits = "трех";

        if ( a>0 && a<1000 ) System.out.println(prticl+"четное "+countOfDidits+"значное число");


    }
}
