package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        int mumber1 = Integer.parseInt(reader.readLine());
//        int mumber2 = Integer.parseInt(reader.readLine());
//        int mumber3 = Integer.parseInt(reader.readLine());
//        int mumber4 = Integer.parseInt(reader.readLine());
        int[] numbers = new int[4];
        int maxNumber = Integer.MIN_VALUE;
        for (int num : numbers){
            num = Integer.parseInt(reader.readLine());
            if (num>maxNumber) maxNumber = num;
        }
        System.out.println(maxNumber);
    }
}
