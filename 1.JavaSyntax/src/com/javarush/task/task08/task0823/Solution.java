package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> usersEnter = new ArrayList<>();

        String s = reader.readLine();

        String[] strArray = s.split("\\b");

            for (int i = 0;i<strArray.length;i++)
                strArray[i]= strArray[i].substring(0, 1).toUpperCase() + strArray[i].substring(1);


            for(String string : strArray)
                System.out.print(string);
        }
}
