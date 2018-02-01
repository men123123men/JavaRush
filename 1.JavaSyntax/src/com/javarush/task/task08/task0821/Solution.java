package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> dictionary = new HashMap<>();
        for(int i=0,j=0,k=5;i<10;i++){
            dictionary.put("Name"+j,"Family"+k);
            if(i%2==0) j++;
            if(i%3==0) k++;
        }

        return dictionary;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet())
            System.out.println(s.getKey() + " " + s.getValue());

    }
}
