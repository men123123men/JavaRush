package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        return StringHelper.multiply(s,5);
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            //result+= s;
            result = result.concat(s);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(StringHelper.multiply("Dfcz"));
    }
}
