package com.javarush.task.experements.generics.philosophyOfJava;

import java.util.Iterator;

public class IterableFibonacci2 implements Iterable<Integer> {
    private Fibonacci innerFibonacci;
    private int count;

    public IterableFibonacci2(Fibonacci innerFibonacci,int count) {
        this.innerFibonacci = innerFibonacci;
        this.count = count;
    }
    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count>0;
            }

            @Override
            public Integer next() {
                --count;
                return innerFibonacci.next();
            }
        };
    }

    public static void main(String[] args){
        for(int i:new IterableFibonacci2(new Fibonacci(),10))
            System.out.println(i);
    }
}
