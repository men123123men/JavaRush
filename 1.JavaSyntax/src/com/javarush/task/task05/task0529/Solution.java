package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int sum =0;
        while(true){
            String str = reader.readLine();
            try {
                sum+= Integer.parseInt(str);
            } catch (NumberFormatException e){
                if (str.equals("сумма")) break;
                else System.err.println(str);
            }
        }
        System.out.println(sum);

    }
}
