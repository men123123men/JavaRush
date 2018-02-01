package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {


        int height = 0;
        while (++height<=10){
            int width = 0;
            while (++width<=10) System.out.print(width*height+" ");
            System.out.println();
        }

    }
}
