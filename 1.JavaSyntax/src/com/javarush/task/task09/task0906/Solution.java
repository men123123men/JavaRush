package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement whence = Thread.currentThread().getStackTrace()[2];
        System.out.println(whence.getClassName()+": "+whence.getMethodName()+": "+s);
    }
}
