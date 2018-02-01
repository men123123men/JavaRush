package com.javarush.task.experements.enumики.philosophyOfJava;

import java.util.stream.Stream;

public class EnumOrder {
    public static void main(String[] args){
        System.out.println(Integer.toHexString(Spiciness.valueOf("NOT").hashCode()));
        Object obj = new Object();
        System.out.println(obj.hashCode());

        Stream.of(Spiciness.values())
                .forEach(e-> System.out.println(e+" ["+e.ordinal()+"]"));
    }
}
