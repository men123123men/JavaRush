package com.javarush.task.task16.task1631;

import java.util.Arrays;

public class Solution {

    public enum Season {WINTER, SPRING, SUMMER, FALL}

    //

    public static void main(String[] args) {
//        for (Season s : Season.values())
//            System.out.println(s.ordinal() + ": " + s);
        Arrays.asList(Season.values()).forEach(s -> System.out.println(s.ordinal()+ ": " + s));
        Season w = Season.WINTER;
        System.out.println(w.getClass());
        System.out.println(w.getDeclaringClass());
        System.out.println(w);
    }

//    public static void main(String[] args) {
//        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
//        System.out.println(reader.getClass().getSimpleName());
//        System.out.println("Ok!");
//    }
}
