package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>();
    private static List<String> maxStrings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));



        int maxLenght = 0;
        int countOfMaxStrings = 0;
        for(int i =0;i<5;i++){
            String enterdString = reader.readLine();
            int lergthOfString = enterdString.length();
            if (lergthOfString>maxLenght) {
                maxStrings.clear();
                maxStrings.add(enterdString);
                maxLenght=enterdString.length();
            }
            else if (lergthOfString==maxLenght) maxStrings.add(enterdString);
            strings.add(enterdString);

        }
        for (String str: maxStrings){
            System.out.println(str);
        }
    }
}
