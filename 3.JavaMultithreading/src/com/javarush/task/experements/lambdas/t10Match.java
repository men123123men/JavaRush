package com.javarush.task.experements.lambdas;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class t10Match {
    public static void main(String[] args){
        List<Integer> numbers = IntStream
                .rangeClosed(1,5)     // статический метод класса IntStream
                .boxed()        // упаковывание в класс обертку
                .collect(Collectors.toList());  // в лист

        boolean anymatch = numbers.stream()
                .anyMatch(n->n==5);
        System.out.println(anymatch);

        boolean allMatch = numbers.stream()
                .allMatch(n->n<5);
        System.out.println(allMatch);

        System.out.println(IntStream.range(1,11).noneMatch(n->n>10));

    }
}
