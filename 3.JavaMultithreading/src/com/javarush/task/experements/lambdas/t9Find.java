package com.javarush.task.experements.lambdas;

import java.util.List;

public class t9Find {
    public static void main(String[] args){
        List<String> words = List.of("BLOB", "Java is the best", "Java 8", "Java 9", "Jacoco");

        words.parallelStream()
                .filter(s->s.matches(".*\\d"))
                .findAny()
                //.ifPresent(System.out::println);
                .ifPresentOrElse(System.out::println,()-> System.out.println("Нет совпадений!"));

        String findFirst = words.stream()
                .filter(s-> s.matches("\\D*\\d"))
                .findFirst().get();


        List<Integer> numers = List.of(1, 5, 8, 10, 12, 15,16,17,18,19,10);

        numers.parallelStream()
                .filter(i->i>10)
                .findFirst()       // findFirst у parallelStream'ов выдает первый элемент
                //.findAny()        // findAny у parallelStream'ов выдает рандомный элемент
                .ifPresent(System.out::println);





    }
}
