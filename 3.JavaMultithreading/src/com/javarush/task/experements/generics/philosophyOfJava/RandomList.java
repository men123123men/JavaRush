package com.javarush.task.experements.generics.philosophyOfJava;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private static Random rand = new Random(47);
    public void add(T item){
        storage.add(item);
    }
    public T select(){
        return storage.remove(rand.nextInt(storage.size()));
    }
    public int size(){
        return storage.size();
    }


    public static void main(String[] args){
        RandomList<String> stringRandomList = new RandomList<>();

        for(String string:"Я ненавижу эту неопределенность!".split(" "))
            stringRandomList.add(string);

        for(;stringRandomList.size()>0;)
            System.out.println(stringRandomList.select());
    }
}
