package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators=comparators;
        }

        @Override
        public int compare(T t1, T t2) {
            return Arrays.stream(comparators)
                    .reduce((ts1,ts2)->0,Comparator::thenComparing)
                    .compare(t1,t2);
        }
    }
    public static void main(String[] args) { }
}
