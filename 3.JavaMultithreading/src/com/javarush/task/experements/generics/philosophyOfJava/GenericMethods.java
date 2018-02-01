package com.javarush.task.experements.generics.philosophyOfJava;

public class GenericMethods {
    public static  <T,U> void f(T x, U y, String  z){
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
        System.out.println();
    }
    public static void main(String[] args) {
//        f("",12,1.3);
//
//        f(1.3F,12L,true);

        try {
            f((char) 13,new GenericMethods(), String.class.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
