package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Bush", new Date("MAY 4 1985"));
        map.put("Ivanov", new Date("JULY 25 1978"));
        map.put("Oland", new Date("NOVEMBER 12 1991"));
        map.put("Ford", new Date("MARCH 21 2003"));
        map.put("Washington", new Date("FEBRUARY 8 1982"));
        map.put("Jeferson", new Date("SEPTEMBER 17 1999"));
        map.put("Mugabe", new Date("APRIL 4 1982"));
        map.put("Adenauer", new Date("DECEMBER 29 2007"));
        map.put("Bismark", new Date("JUNE 3 1975"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {

//        for(Map.Entry<String, Date> pair: map.entrySet())
//            if (pair.getValue().getMonth()>= 5 && pair.getValue().getMonth() <= 7)
//                map.remove(pair.getKey().toString());

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth()>= 5 && pair.getValue().getMonth() <= 7)
                iterator.remove();
       }

    }

    public static void main(String[] args) {

    }
}
