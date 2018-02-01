package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int minInt =Integer.MAX_VALUE;
        for(int currentNumber: array)
            if(currentNumber<minInt) minInt=currentNumber;

        return minInt;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<size;i++)
            result.add(Integer.parseInt(reader.readLine()));

        return result;
    }
}
