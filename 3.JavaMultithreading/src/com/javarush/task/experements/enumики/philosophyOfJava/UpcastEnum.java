package com.javarush.task.experements.enumики.philosophyOfJava;

import java.util.Arrays;

enum Search {HITHER,YON}


//final class Search extends Enum<Search> {
//        public static final Search HERE = new Search("HERE",0);
//        public static final Search THERE = new Search("THERE",1);
//
//    /**
//     * Sole constructor.  Programmers cannot invoke this constructor.
//     * It is for use by code emitted by the compiler in response to
//     * enum type declarations.
//     *
//     * @param name    - The name of this enum constant, which is the identifier
//     *                used to declare it.
//     * @param ordinal - The ordinal of this enumeration constant (its position
//     *                in the enum declaration, where the initial constant is assigned
//     */
//    protected Search(String name, int ordinal) {
//        super(name, ordinal);
//    }
//
//    public static Search[] values(){};
//    public static Search valueOf(String arg0){};
//    static {};
//}

public class UpcastEnum {
    public static void main(String[] args){
        Search[] vals = Search.values();
        Search[] vals2 = Search.class.getEnumConstants();
        Integer[] integers = Integer.class.getEnumConstants();

//        System.out.println(integers.length);
//        Object o = integers[0];
//        for(int i:integers)
//            System.out.println(i);

        Arrays.stream(vals2)
                .forEach(System.out::println);
    }
}
