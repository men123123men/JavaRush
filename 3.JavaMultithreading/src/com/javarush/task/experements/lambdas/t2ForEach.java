package com.javarush.task.experements.lambdas;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class t2ForEach {
    public static void main(String... args){
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1,2,3,4,5, (int) '6',(int) 7d));
        numbers.forEach(System.out::println);

        Map<Integer, Integer> numbers2 = new HashMap<>();
        numbers2.put(1, 100);
        numbers2.put(2, 200);
        numbers2.put(3, 300);


        numbers2.entrySet().forEach(new Consumer<Map.Entry<Integer, Integer>>() {
            @Override
            public void accept(Map.Entry<Integer, Integer> integerIntegerEntry) {
                System.out.println(integerIntegerEntry.getKey()+"=1>"+integerIntegerEntry.getValue());
            }
        });
        numbers2.entrySet().forEach(v-> System.out.println(v.getKey()+"=2>"+v.getValue()));
        numbers2.entrySet().forEach(System.out::println);

        numbers2.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                if(integer>2)return;
                System.out.println(integer+"=3>"+integer2);

            }
        });





    }
}
