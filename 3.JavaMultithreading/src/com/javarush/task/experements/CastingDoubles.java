package com.javarush.task.experements;

public class CastingDoubles {
    public static void main(String[] args) {
        double d0  =          1/          2; // 0.0
        double d00 =    (int) 1/    (int) 2; // 0.0
        double d1  = (double) 1/          2; // 0.5
        double d10 = (double) 1/    (int) 2; // 0.5
        double d2  =          1/ (double) 2; // 0.5
        double d20 =    (int) 1/ (double) 2; // 0.5

        double d3 =           (int)  1/2 ;      // 0.0
        double d4 =  (double) (int)  1/2 ;      // 0.5
        double d5 =  (int) (double)  1/2 ;      // 0.0
        double d6 =  (double) (int) (1/2);      // 0.0
        double d7 =        (double) (1/2);      // 0.0


        System.out.println(d0);
        System.out.println(d00);
        System.out.println(d1);
        System.out.println(d10);
        System.out.println(d2);
        System.out.println(d20);
        System.out.println();

        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println();

        double d38 =           (int)  1/2 ;      // 0.0
        double d48 =  (double) (int)  1/2 ;      // 0.5
        double d49 =  (double)        d38 ;      // 0.0
        System.out.println(d38);
        System.out.println(d48);
        System.out.println(d49);







    }
}
