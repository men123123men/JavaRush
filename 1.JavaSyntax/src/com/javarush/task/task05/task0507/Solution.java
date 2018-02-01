package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        //int averege=0;
        int currentNumber =Integer.parseInt(reader.readLine());
        int sum=0;
        int count = 0;

        while(currentNumber  !=-1) {
            sum+=currentNumber;
            count++;
            currentNumber = Integer.parseInt(reader.readLine());
        }
        double averege = count!=0 ? (double) sum/count : 0 ;
        System.out.println(averege);




    }
}

