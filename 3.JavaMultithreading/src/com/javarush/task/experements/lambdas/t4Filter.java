package com.javarush.task.experements.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class t4Filter {
    public static void main(String... args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(i -> i%2==0)
                .forEach(System.out::println);


        //Predicate p1 =

        List<String> names = Arrays.asList(
                "John", "Jan", "Tirion", "Marry", "Nikolas", "", null, "Arya");

        Predicate<String> predicat = n -> n!=null&&n.length()>4;

        names.stream()
                .filter(predicat)
                .forEach(System.out::println);

        names.stream()
                .filter(Objects::nonNull)
                .filter(n->n.length()>4)
                .forEach(System.out::println);




    }
}
