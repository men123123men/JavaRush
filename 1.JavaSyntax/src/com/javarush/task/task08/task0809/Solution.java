package com.javarush.task.task08.task0809;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
Время для 10 тысяч вставок
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getTimeMsOfInsert(new ArrayList()));
        System.out.println(getTimeMsOfInsert(new LinkedList()));
    }

    public static long getTimeMsOfInsert(List list) {
        Date stert = new Date();

        insert10000(list);

        Date finish = new Date();

        //return finish.getTime()-stert.getTime();
        return finish.compareTo(stert);


    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
        }
    }
}
