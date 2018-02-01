package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //System.out.println("Begin of createSet()");
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i<20;i++) {
            double randomDoud = 20 * Math.random();
            int randovInt = (int) randomDoud;
            //System.out.println(randovInt);
            result.add(i);
        }
        //System.out.println("End of createSet()");
        return result;



    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
            if (iterator.next()>10)
                iterator.remove();

        return set;


    }

    public static void main(String[] args) {
       // for(int number: removeAllNumbersMoreThan10(createSet()))
           // System.out.println(number);
    }
}
