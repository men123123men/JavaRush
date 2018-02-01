package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {                        //  result: 1000.0
        short b = (short) 45;                                       System.out.println("b = "+b);
        char c = (short) 99;                                        System.out.println("c = "+c);
        short s = (byte) 1005.22;                                  System.out.println("s = "+s);
        int i = (short) 150000;                                     System.out.println("i = "+i);
        float f =  4.10f;                                    System.out.println("f = "+f);
        double d = 1.256d;                                  System.out.println("d = "+d);
        double result = (f * b) + (i / c) - (d * s) + 562.78d;      System.out.println("result: " + result);
    }
}