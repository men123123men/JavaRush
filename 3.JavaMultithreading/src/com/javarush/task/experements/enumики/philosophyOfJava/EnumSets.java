package com.javarush.task.experements.enumики.philosophyOfJava;

import java.util.EnumSet;
import java.util.function.Predicate;

enum AlarmPoints {
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3,
    OFFICE4, BATHROOM, UTILITY, KITCHEN
}
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);

        EnumSet<AlarmPoints> points2 = points.noneOf(AlarmPoints.class);
        System.out.println(points2);


        Predicate<AlarmPoints> wee = e-> e.name().matches(".*\\D");
        //points.removeIf(wee);
        points.stream()
                .filter(wee)
                .forEach(System.out::println);





    }

}
