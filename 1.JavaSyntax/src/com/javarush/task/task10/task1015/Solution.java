package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {

        ArrayList<String>[] ar = new ArrayList[10];
        for (int i = 0; i < ar.length; i++){
            ar[i] =  new ArrayList<String>();
            ar[i].add("r" + i);}
        return ar;


//        ArrayList[] arrayLists = new ArrayList[10];
//        Random myRand = new Random();
//        for(int i=0;i<10;i++){
//            arrayLists[i] = new ArrayList<String>();
//            for (int j=0;j<10;j++){
//                arrayLists[i].add(j,  "Массив № "+(i+1)+" Строка № "+(j+1)+": "+myRand.nextInt(100));
//            }
//        }
//        return arrayLists;


    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}