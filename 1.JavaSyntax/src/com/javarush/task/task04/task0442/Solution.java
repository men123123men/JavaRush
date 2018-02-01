package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        int sum = 0;
        while (number != -1) {

            number = Integer.parseInt(reader.readLine());
            sum += number;
        }
        System.out.println(sum);

    }
}
