package com.javarush.task.task07.task0715;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] providedStrs = {"мама","мыла","раму"};
        ArrayList<String> rezult = new ArrayList<String>();
        for(int i=0;i<providedStrs.length;i++){
            rezult.add(providedStrs[i]);
            if (i!=providedStrs.length) rezult.add("именно");
        }
        for(int i=0;i<rezult.size();i++)
            System.out.println(rezult.get(i));
    }
}
