package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> enteredStrs = new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<5;i++)
            enteredStrs.add(reader.readLine());
        //String replacementStr = "";
        for(int i = 0; i<13; i++){
            enteredStrs.add(0,enteredStrs.get(enteredStrs.size()-1));
            enteredStrs.remove(enteredStrs.size()-1);
        }
        for (int i=0;i<enteredStrs.size();i++)
            System.out.println(enteredStrs.get(i));
    }
}
