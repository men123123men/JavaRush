package com.javarush.task.task03.task0324;

/* 
Меркантильные намерения
*/

public class Solution {
    public static int sumDigitsInNumber(int number){
        int result = 0;
        while (number!=0){
            result+=number%10;
            number/=10;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(765));


    }
}
