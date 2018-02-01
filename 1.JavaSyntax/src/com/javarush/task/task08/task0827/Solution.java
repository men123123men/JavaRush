package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {
        Date date1 = new Date(date);
        Date startOfTheYear = new Date(date1.getTime());
        startOfTheYear.setDate(1);
        startOfTheYear.setMonth(0);
        long differenceLong = (date1.getTime()-startOfTheYear.getTime())/1000/3600/24;
        return differenceLong%2==0;
    }
}

