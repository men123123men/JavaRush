package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {
    public static void divisionByZero(){System.out.println(6/0);}
    public static void main(String[] args) {
        try{
            divisionByZero();
        } catch (ArithmeticException exception){
            exception.printStackTrace();
        }
    }
}
