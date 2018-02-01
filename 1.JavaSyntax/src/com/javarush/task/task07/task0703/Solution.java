package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
        String[] arrayOfStr = new String[10];
        int[] arrayOfLength = new int[arrayOfStr.length];

        for (int i = 0; i < arrayOfStr.length; i++) {
            arrayOfStr[i] = reader.readLine();
            arrayOfLength[i] = arrayOfStr[i].length();
            printStream.println(arrayOfLength[i]);
        }
        printStream.flush();
    }
}
