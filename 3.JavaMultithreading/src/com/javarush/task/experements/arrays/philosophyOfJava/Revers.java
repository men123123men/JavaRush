package com.javarush.task.experements.arrays.philosophyOfJava;

import java.util.Arrays;

public class Revers {
    public static void main(String[] args){
        int[] simpleIntArray = { 2, 4, 6, 8, 10 };

        reverse(simpleIntArray);// Получим на консоль [10, 8, 6, 4, 2]
        System.out.println(Arrays.toString(simpleIntArray));

        String string = "123456789";
        String reversString = reverse(string);
        System.out.println(reversString);


    }
    public static void reverse(int[] array){
        int temp;
        int length = array.length;

        for(int i=0;i<length/2;i++){
            temp = array[i];
            array[i] = array[length-1-i];
            array[length-1-i] = temp;

        }

    }
    public static void reverse2(int[] array){
        int temp;
        int length = array.length;
        int i=0;
        while (i<length/2){
            temp = array[i++];
            array[i-1] = array[length-i];
            array[length-i] = temp;
        }

    }

    public static String reverse(String string){

        int position = string.length();
        StringBuilder result = new StringBuilder();

        while(position>0)
            result.append(string.charAt(--position));

        return result.toString();
    }
}
