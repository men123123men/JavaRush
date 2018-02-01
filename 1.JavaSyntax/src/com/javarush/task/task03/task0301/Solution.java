package com.javarush.task.task03.task0301;

/* 
Делиться полезно
*/

public class Solution {
    public static void main(String[] args) {
        div(6, 3);
        div(10, 6);
        div(2, 4);
    }

    public static void div(int a, int b) {
        int result  = (int) a/b;
        System.out.print(a/b+" ");
        if (counter<2) System.out.println();
    }
    public static int counter = 0;
}
