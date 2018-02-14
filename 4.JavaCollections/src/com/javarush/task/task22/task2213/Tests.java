package com.javarush.task.task22.task2213;

import java.util.Arrays;
import java.util.Random;

public class Tests {
    public static void main(String[] args){
        int[][] array = new int[10][8];
        print(array);

        initial(array);
        print(array);

        removeFullLines(array);
        print(array);


    }

    public static void print(int[][] array){
        for(int i = 0;i<array.length;i++) { // for(int i = array.length-1;i>0;i--) {  // for(int[] string:array){

            for (int element: array[i])            // for (int element: string)
                System.out.print(element);
            System.out.println();
        }
        System.out.println();
    }
    public static void initial(int[][] array){
        Random random = new Random();
        int currentValue;
        for(int i =0;i<array.length;i++) {
            currentValue = random.nextInt(5);
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = currentValue;
        }
    }

    public static void removeFullLines(int[][] array) {
        int bedValues = new Random().nextInt(5);
        System.out.println("Удаляем "+bedValues);

        int[] fullString = new int[array[0].length];
        Arrays.fill(fullString,bedValues);
        for(int i=0;i<array.length;i++){
            if (Arrays.equals(array[i],fullString)){
//                System.arraycopy(array,i+1,array,i,array.length-i-1);
//                array[array.length-1] = new int[array[0].length];

                System.arraycopy(array,0,array,1,i);
                array[0] = new int[array[0].length];

            }
        }


//        int[] fullOfOne = new int[array[0].length];
//        Arrays.fill(fullOfOne, bedValues);
//
//        List<int[]> result = Arrays.asList(array).stream()
//                .filter((x) -> !Arrays.equals(x, fullOfOne))
//                .collect(Collectors.toList());
//
//        int diference = array.length - result.size();
//
//        for (int i = 0; i < diference; i++)
//            result.add(0, new int[array[0].length]);
//
//        for (int i = 0; i < array.length; i++)
//            array[i] = result.get(i);



    }










}
