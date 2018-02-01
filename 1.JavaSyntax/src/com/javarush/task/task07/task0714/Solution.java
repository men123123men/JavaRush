package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> enteredStrs = new ArrayList<>();
        for(int i = 0; i<5;i++)
            enteredStrs.add(reader.readLine());
        enteredStrs.remove(2);
        for(int i = enteredStrs.size()-1;i>=0;i--)
            System.out.println(enteredStrs.get(i));


    }
}


