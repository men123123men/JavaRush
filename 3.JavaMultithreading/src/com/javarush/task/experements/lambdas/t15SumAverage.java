package com.javarush.task.experements.lambdas;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class t15SumAverage {
    public static void main(String[] args){
        int[] ints =  IntStream.rangeClosed(1,5)
                            .toArray();
        long[] longs = LongStream.range(1,5)
                            .toArray();
        double[] doubles = DoubleStream.of(3.0, 30.0,4.5,6.7,6,5)
                            .toArray();




        double sumOfDoubles = Arrays.stream(doubles).sum();

        double avarageOfDoubles = Arrays.stream(ints).average().getAsDouble();


        DoubleStream doubleStream = IntStream.rangeClosed(1, 100)
                            .asLongStream()
                            .asDoubleStream();





    }
}
