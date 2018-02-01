package com.javarush.task.experements.threadPool_habr;

import java.util.stream.IntStream;

public class Counter {

    public static void main(String[] args){

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(1<<27);
        //System.out.println(count(2));
//        System.out.println(Math.log(1_000_000)/Math.log(2));
//        System.out.println(1<<20);
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
    public  double count(double a){
        for(int i=1; i<=1_000_000 ;i++)
            a = a + Math.tan(a);
        return a;
    }
    public static double count2(double a){
        return IntStream.rangeClosed(1,10).asDoubleStream()
                .reduce(a,(p, q)-> p + Math.tan(q));

    }

}
