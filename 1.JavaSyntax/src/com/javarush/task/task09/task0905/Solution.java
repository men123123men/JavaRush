package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        int countOfStackTraceElements = Thread.currentThread().getStackTrace().length;
        System.out.println(countOfStackTraceElements);
        return countOfStackTraceElements;
    }
}

