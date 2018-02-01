package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        ArrayList<String> arrayOfStrings = new ArrayList();

        while (true){
            str = reader.readLine();
            if (str.equals("end")) break;
            arrayOfStrings.add(str);
        }
        for(String currentStr: arrayOfStrings)
            System.out.println(currentStr);


    }
}