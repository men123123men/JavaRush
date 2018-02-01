package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String ,String> first2names = new HashMap<>();
        for(int i = 0; i<10;i++)
            first2names.put("Family"+i,"Name");
        return first2names;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {

        int countTheSameFirstName=0;
        for (Map.Entry<String ,String > pair: map.entrySet())
            if (pair.getValue().equals(name)) countTheSameFirstName++;


        return countTheSameFirstName;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {

        int countTheSameLastName=0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
            if(iterator.next().getKey().equals(lastName)) countTheSameLastName++;
        return countTheSameLastName;
    }

    public static void main(String[] args) {

    }
}
