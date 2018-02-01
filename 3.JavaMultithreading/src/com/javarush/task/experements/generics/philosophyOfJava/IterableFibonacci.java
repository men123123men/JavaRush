package com.javarush.task.experements.generics.philosophyOfJava;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Object next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args){
        int count=0;
        for(Integer i:new IterableFibonacci(18))
            System.out.println(++count+") "+i);
    }
}
