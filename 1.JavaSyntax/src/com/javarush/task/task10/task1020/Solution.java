package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        for(int rengeEnd = array.length; rengeEnd>0 ; rengeEnd--){
            for(int comparedNowIndex=0; comparedNowIndex<rengeEnd-1; comparedNowIndex++) {
                if (array[comparedNowIndex] > array[comparedNowIndex + 1]) {
                    int tem = array[comparedNowIndex];
                    array[comparedNowIndex] = array[comparedNowIndex + 1];
                    array[comparedNowIndex + 1] = tem;
                }
            }
        }
    }
}
