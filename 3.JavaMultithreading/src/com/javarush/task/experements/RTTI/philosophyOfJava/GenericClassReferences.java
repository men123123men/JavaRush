package com.javarush.task.experements.RTTI.philosophyOfJava;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
                       genericIntClass = Integer.class; // To же самое




        intClass = double.class;
        // genericIntClass = double.class; // Недопустимо

        boolean bool = true;
        System.out.println(((Boolean) bool).getClass());
        System.out.println(Boolean.TYPE);
        System.out.println(int.class);
        System.out.println(Integer.class);
        System.out.println(int[].class);
        System.out.println(String.class);
        System.out.println(String[].class);
        System.out.println(GenericClassReferences.class);
        System.out.println(GenericClassReferences[].class);
        System.out.println(void.class);

    }
}
