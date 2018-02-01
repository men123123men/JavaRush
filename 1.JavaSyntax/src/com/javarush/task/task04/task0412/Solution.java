package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(reader.readLine());
        if(choice<0) System.out.println(++choice);
        else  if (choice==0) System.out.println(choice);
        else System.out.println(choice*=2);

    }

}