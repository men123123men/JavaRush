package com.javarush.task.experements.lambdas;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class t14LimitSkip {
    public static void main(String[] args){
        IntStream.rangeClosed(1,10)
                .limit(5)          // ОСТАВЛЯЕТ ПЕРВЫЕ 5 элементов
                .forEach(System.out::println);      System.out.println();

        IntStream.generate(()->111)
                .limit(5)
                .forEach(System.out::println);      System.out.println();

        IntStream.generate(()->new Random().nextInt(10))
                .limit(5)
                .forEach(System.out::println);      System.out.println();

        IntStream.iterate(4,i->(i+17)%23)
                .limit(5)
                .forEach(System.out::println);      System.out.println();

        new Random().ints(10,20)
                .limit(5)
                .forEach(System.out::println);      System.out.println();

        new Random().ints(5,20,30)
                .forEach(System.out::println);      System.out.println();

//        String str = "string";
//        System.out.println(str.charAt(3));
//        System.out.println(str.codePointAt(3));


        IntStream.rangeClosed(1,10)
                .skip(5)         // ПРОПУСКАЕТ ПЕРВЫЕ 5 элементов
                .forEach(System.out::println);      System.out.println("Условные огроничения:");

        new Random().ints(5,1,10)
                .takeWhile(i->i<=5)  // похоже на limit()
                .forEach(System.out::println);      System.out.println();

        Arrays.stream(new Random().ints(5,1,10).toArray())
                .dropWhile(i->i<4)   // похоже на skip()
                .forEach(System.out::println);      System.out.println();



    }
}
