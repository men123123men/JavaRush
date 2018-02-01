package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        String surrender = null;
        for (int i = array.length-1; i > 0;i--) {
            for (int j = 0; j < i; j++) {
                if (isGreaterThan(array[j], array[j + 1])) {
                    surrender = array[j];
                    array[j] = array[j+1];
                    array[j+1] = surrender;
                }
            }
        }
    }
    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}

//
//        for (int i = 0; i < N; i++)
//            for (int j = i + 1; j < N; j++)
//                if (r[j] < r[i]) {
//                    t = r[i];
//                    r[i] = r[j];
//                    r[j] = t;
//                }
//








