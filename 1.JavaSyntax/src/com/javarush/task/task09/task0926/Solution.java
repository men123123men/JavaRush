package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {

        ArrayList<int[]> result = new ArrayList<>();
        int[] lengthOfArrays = {5, 2, 4, 7, 0};


        for(int lengthOfCurrentArray : lengthOfArrays){

            int[] currentArray = new int[lengthOfCurrentArray];

            for(int i = 0;i<lengthOfCurrentArray;i++)
                currentArray[i] =  (int) (Math.random()*100);

            result.add(currentArray);

        }
        return result;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
