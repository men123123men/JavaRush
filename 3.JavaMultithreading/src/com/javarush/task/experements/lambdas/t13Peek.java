package com.javarush.task.experements.lambdas;

import java.util.stream.IntStream;

public class t13Peek {
    public static void main(String[] args){

        IntStream.rangeClosed(1,5)
                .peek(System.out::println)
                .filter(n->{
                    System.out.println(n);
                    return true; })
                .map(n->{
                    System.out.println(n);
                    return n; })
                .forEach(n-> {} );


    }










}
