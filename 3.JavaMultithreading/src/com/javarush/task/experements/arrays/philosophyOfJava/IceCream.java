package com.javarush.task.experements.arrays.philosophyOfJava;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    public static String[] flavorSet(int n) {
        if(n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for(int i = 0; i < n; i++) {
            int t;
            do
                t = rand.nextInt(FLAVORS.length);
            while(picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }
    public static void main(String[] args) {
//        for(int i = 0; i < 7; i++)
//            System.out.println(Arrays.toString(flavorSet(3)));

        int[][][] ints2D = new int[2][2][4];//{{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(ints2D));

        int[][] intsTen = new int[2][5];
        System.out.println(Arrays.deepToString(intsTen));

    }
}
