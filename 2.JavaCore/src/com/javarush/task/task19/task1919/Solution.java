package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Float> treeMap = new TreeMap<>();
        String[] lines;
        while (reader.ready()){
            lines = reader.readLine().split(" ");
            String key = lines[0];
            float value = Float.parseFloat(lines[1]);
            if(treeMap.containsKey(key))
                treeMap.replace(key, treeMap.get(key)+value);
            else
                treeMap.put(key,value);
        }
        for(Map.Entry<String,Float> pair : treeMap.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        reader.close();
    }
}
