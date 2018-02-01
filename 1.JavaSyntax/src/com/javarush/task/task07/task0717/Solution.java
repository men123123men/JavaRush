package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<10;i++)
            list.add(reader.readLine());

        ArrayList<String> result = doubleValues(list);

        for(String str: result)
            System.out.println(str);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> rezult = new ArrayList<String>();
        for (String currentStr: list) {
            rezult.add(currentStr);
            rezult.add(currentStr);
        }
        return rezult;
    }
}
