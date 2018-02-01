package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayOfStings = new ArrayList<String>();
        for(int i = 0; i<5; i++){
            arrayOfStings.add(Integer.toString(i));
         }
        System.out.println(arrayOfStings.size());
        for( String str: arrayOfStings){
            System.out.println(str);
        }


    }
}
