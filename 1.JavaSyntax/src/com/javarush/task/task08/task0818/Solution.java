package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Math.random;
/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i<10;i++)
            map.put("Фамилия"+ random()*10 , (int) (Math.random()*1000));
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> current = iterator.next();
            if (current.getValue()<500) iterator.remove();
        }



//        for(Map.Entry<String, Integer> pair: map.entrySet())
//            if (pair.getValue()<500) map.remove(pair.getKey());



    }

    public static void main(String[] args) {

    }
}