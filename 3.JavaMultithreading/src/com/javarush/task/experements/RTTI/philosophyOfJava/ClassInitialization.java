package com.javarush.task.experements.RTTI.philosophyOfJava;

import java.util.*;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args) throws Exception {

        // НЕ инициализирует класс Initable
        Class initable = Initable.class;
        System.out.println("\tAfter creating Initable ref");

        // НЕ инициализирует класс Initable
        System.out.println("\tInitable.staticFinal "+Initable.staticFinal); //не инициализирует класс Initable

        // ИНИЦИАЛИЗИРУЕТ класс Initable
        System.out.println("\tInitable.staticFinal2 "+Initable.staticFinal2);

        // ИНИЦИАЛИЗИРУЕТ класс Initable2
        System.out.println("\tInitable2.staticNonFinal "+Initable2.staticNonFinal);

        // ИНИЦИАЛИЗИРУЕТ класс Initable3
        Class initable3 = Class.forName("com.javarush.task.experements.RTTI.philosophyOfJava.Initable3");
        System.out.println("\tAfter creating Initable3 ref");
        System.out.println("\tInitable3.staticNonFinal "+Initable3.staticNonFinal);
    }
}
