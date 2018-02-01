package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        String numbersString = "ноль один два три четыре пять шесть семь восемь девять десять одиннадцать двенадцать";
        String[] munders = numbersString.split(" ");
        for(int i=0; i<munders.length; i++)
            map.put(i, munders[i]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader (new FileReader(reader.readLine()));
        //BufferedReader fr = new BufferedReader (new FileReader("/Users/admin/Desktop/замена чисел.txt"));
        StringBuffer sb = new StringBuffer();
        while(fr.ready())
            sb.append(fr.readLine());
        reader.close();
        fr.close();
        String s = sb.toString();
        for (Map.Entry<Integer, String> pair : map.entrySet())
            s = s.replaceAll("\\b"+pair.getKey()+"\\b", pair.getValue());
        System.out.println(s);
        Thread.currentThread().interrupt();

    }
}
