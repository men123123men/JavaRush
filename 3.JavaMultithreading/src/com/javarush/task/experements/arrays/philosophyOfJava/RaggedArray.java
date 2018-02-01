package com.javarush.task.experements.arrays.philosophyOfJava;

import java.util.Arrays;

public class RaggedArray {
    public static void main(String[] args){


        int[][][] a3 =new int[rand()][][];
        for (int i=0; i<a3.length;i++) {
            a3[i] = new int[rand()][];
            for (int j=0; j<a3[i].length;j++) {
                a3[i][j] = new int[rand()];
                for (int k = 0; k < a3[i][j].length; k++) {
                    a3[i][j][k] = rand();
                }
            }
        }
        System.out.println(Arrays.deepToString(a3));

        Arrays.stream(a3)
                .flatMap(Arrays::stream)
                .flatMapToInt(Arrays::stream)
                //.map(Arrays::toString)
                .forEach(System.out::println);


        int[] iii = new int[5];
        for(int i:iii)
            i=2;  // не пороисходит присвоения!!!!!
        //System.out.println(Arrays.toString(iii));





    }
    public static int rand(){
        return (int) (Math.random()*5);
    }
}
