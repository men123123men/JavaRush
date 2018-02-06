package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> allInput   = reader.lines().limit(20).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> dividedBy3 = allInput.stream().filter(i->i%3==0).collect(Collectors.toList());
        List<Integer> dividedBy2 = allInput.stream().filter(i->i%2==0).collect(Collectors.toList());
        List<Integer> others     = allInput.stream().filter(i->i%3!=0&&i%3!=0).collect(Collectors.toList());

        printList(dividedBy3);
        printList(dividedBy2);
        printList(others);
    }
    public static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
