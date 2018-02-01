package com.javarush.task.experements.innerClasses.philosophyOfJava;

import java.lang.reflect.Constructor;

//: innerclasses/Parcel1.java
// Creating inner classes.
public class Parcel1 {

    class Contents {
        private int i = 11;
        public int value() { return i; }
    }

    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }

    // Использование внутренних классов имеет много общего
    // с использованием любых других классов в пределах Parcel1
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);

        for (Constructor constructor: d.getClass().getConstructors()) {
            System.out.println(constructor.getName());
            System.out.println("efe");
        }
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
