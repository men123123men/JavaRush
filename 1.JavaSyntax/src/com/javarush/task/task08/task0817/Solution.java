package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        Map map = new HashMap<String, String>();
        for (int i = 0; i<10;i++)
            map.put("Фамилия"+i, "Имя"+Math.random()*10);
        return (HashMap<String, String>) map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> temp = new HashMap<>(map);
        for(Map.Entry<String, String> pair : temp.entrySet()){
            int k = 0;
            for(Map.Entry<String, String> pair1 : map.entrySet())
                if(pair.getValue().equals(pair1.getValue()))  k++;

            if(k > 1) removeItemFromMapByValue(map, pair.getValue());
        }
    }



    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {

        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
