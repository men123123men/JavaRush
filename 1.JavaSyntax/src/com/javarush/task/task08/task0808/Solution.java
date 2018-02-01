package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);
        //arrayList.forEach(System.out::println);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list) {
        for(int i = 0;i<10001;i++)
            list.add(i);
    }

    public static void get10000(List<Integer> list) {
        for(int i = 0; i<10000;i++)
            list.get(i);
    }

    public static void set10000(List<Integer> list) {
        for(int i = 0; i<10001;i++)
            list.set(i,i*3);

    }

    public static void remove10000(List list) {

//        ListIterator<Integer> listIterator = list.listIterator();
//
//        while (listIterator.hasNext()) {
//            listIterator.next();
//            listIterator.remove();
//        }
//        for(int i = 0; i<10000;i++)
//            list.remove(0);
        //list.stream().skip(10000).forEach(System.out::println);
        List<Integer> intList = (List<Integer>) list.stream().skip(10000).collect(Collectors.toList());
        list = intList;
    }
}
