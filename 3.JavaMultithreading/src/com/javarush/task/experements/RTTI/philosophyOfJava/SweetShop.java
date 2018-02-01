package com.javarush.task.experements.RTTI.philosophyOfJava;

class Candy {
    static {
        System.out.println("\tЗагрузка класса Candy"); }
}

class Gum {
    static { System.out.println("\tЗагрузка класса Gum"); }
}

class Cookie {
    static { System.out.println("\tЗагрузка класса Cookie"); }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("в методе main()");
        new Candy();
        System.out.println("После создания объекта Candy");
        Class clazz = Gum.class;
        try {
            Class.forName("com.javarush.task.experements.RTTI.philosophyOfJava.Gum");

        } catch(ClassNotFoundException e) {
            System.out.println("Класс Gum не найден");
        }
        System.out.println("После вызова метода Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("После создания объекта Cookie");
    }
}
