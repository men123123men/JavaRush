package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
//        for (int i = 0; i < 130; i++) {
//            System.out.print(i+"\t) ");
//            checkInterval(i);
//
//        }
    }

    public static void checkInterval(int a) {
        String particl = ((a-75)<25&&(a-75)>-25) ?"":"не";
        System.out.println("Число "+a+" "+particl+" содержится в интервале.");
    }
}