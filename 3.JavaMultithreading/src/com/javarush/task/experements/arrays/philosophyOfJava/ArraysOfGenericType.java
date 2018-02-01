package com.javarush.task.experements.arrays.philosophyOfJava;

public class ArraysOfGenericType<T> {
    T[] array;

    public ArraysOfGenericType(int size) {
        //array = new T[size];
        array = (T[]) new Object[size];



    }

    public static void main(String[] args){

    }
}
