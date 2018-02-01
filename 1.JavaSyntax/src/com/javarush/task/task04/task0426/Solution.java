package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        String signiture = number>0 ? "положительное" : "отрицательное";
        String parity = number%2==0 ? "четное":"нечетное";
        System.out.println(number==0 ? "ноль" : signiture+" "+parity+" число");



    }
}
