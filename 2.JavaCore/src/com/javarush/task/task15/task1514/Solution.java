package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/*
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(5.0 , "Excellent");
        labels.put(4.0 , "Good");
        labels.put(3.0 , "Satisfactory");
        labels.put(2.0 , "Bed");
        labels.put(1.0 , "Very bed");
    }
    public static void main(String[] args) {
        for(Map.Entry<Double, String> pair: labels.entrySet())
            System.out.println(pair);
    }
}
