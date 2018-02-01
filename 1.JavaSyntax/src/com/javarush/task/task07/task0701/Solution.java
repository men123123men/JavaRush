package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int arrayOfInts[] = new int[20];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arrayOfInts.length; i++) {
            arrayOfInts[i] = Integer.parseInt(reader.readLine());
        }
        return arrayOfInts;
    }

    public static int max(int[] array) {
        int maxInt = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>maxInt) maxInt= array[i];
        }
        return maxInt;
    }
}
