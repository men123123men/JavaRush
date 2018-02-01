package com.javarush.task.experements.generics.philosophyOfJava;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyMinMax<T extends Comparable<T>> implements MinMax<T>{

    T[] values;

    public MyMinMax(T[] values) {
        this.values = values;
    }

    @Override
    public T max() {
        T max = values[0];
        for(T current: values)
            if(current.compareTo(max)>0)
                max = current;
        return max;

    }

    @Override
    public T min() {
        T min = values[0];
        for(T current:values)
            if(current.compareTo(min)<0)
                min = current;
        return min;
    }

    public static void main(String[] args) throws IOException {

        Integer[] rands = new Random().ints(10,1,1001).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        System.out.println(Arrays.toString(rands));

        Double[] doubles = new Random().doubles(10,1,1001).boxed().sorted(Comparator.reverseOrder()).toArray(Double[]::new);
        String doudleStr = Stream.of(doubles).map(Object::toString).sorted(Comparator.reverseOrder()).collect(Collectors.joining(", ","[","]"));
        System.out.println(doudleStr);

        MyMinMax minMax = new MyMinMax(doubles);
        //int maxValue = (int) minMax.max();
        System.out.println(minMax.max().getClass());


        System.out.println(GetIterationsCount(100000));
    }
        public static int GetIterationsCount(int n)
        {
            int size = 1;
            int iterationsCount = 0;
            for (int count = 0; count < n; count++) {
                if (count >= size) {
                    size = 2 * size;
                    for (int i = 0; i < size; i++)
                        iterationsCount++;
                }
                iterationsCount++;
            }
            return iterationsCount;
        }


}
interface MinMax<T extends Comparable<T>>{
    T max();
    T min();
}