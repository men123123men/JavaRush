package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
//        double melian;// = array.length%2==0?((double)array[array.length/2]+array[array.length/2+1])/2:(double)array[array.length/2];
//
//        if(array.length%2==0)
//            melian = ((double)array[array.length/2]+(double)array[array.length/2+1])/2;
//        else
//            melian = (double)array[array.length/2];
//                    Comparator<Integer> comparator = Comparator
//                .comparing((Integer i) -> Math.abs(i - melian))
//                .thenComparingInt(i->i);
//
//
//
//        return  Arrays.stream(array)
//                .sorted(comparator)
//                .toArray(Integer[]::new);

        int median;
        Arrays.sort(array);

        if (array.length%2==0) median = (array[array.length/2] + array[array.length/2-1])/2;
        else median = array[array.length/2];


        Arrays.sort(array, Comparator.comparingInt(x -> Math.abs(median - x)));
        return array;

    }
}
