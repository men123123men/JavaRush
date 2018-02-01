package com.javarush.task.task08.task0813;

import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> rezult = new HashSet<>();
        for(int i = 0; i<20;i++)
            rezult.add("Л"+i);
        return  rezult;
    }

    public static void main(String[] args) {
//        for (String str: createSet())
//            System.out.println(str);
    }
}
