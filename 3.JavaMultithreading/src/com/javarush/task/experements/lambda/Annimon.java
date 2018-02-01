package com.javarush.task.experements.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Annimon {
    public static void main(String[] args) {



//        Stream.empty()                - Пустой стрим:                  // Stream<String>
//        list.stream()                 - Стрим из List:                 // Stream<String>
//        map.entrySet().stream()       - Стрим из Map:                  // Stream<Map.Entry<String, String>>
//        Arrays.stream(array)          - Стрим из массива:              // Stream<String>
//        Stream.of("a", "b", "c")      - Стрим из указанных элементов:  // Stream<String>








        List<String> list = Arrays.stream(args)
                .filter(s -> s.length() <= 2)
                .collect(Collectors.toList());



        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::print);                    System.out.println();

        Arrays.asList("aa1","cc2", "cc1", "aa2", "bb1").stream()
                .filter(s -> s.matches(".+2"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);                   System.out.println();










    }
}
