package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(reader.readLine());
        int width = Integer.parseInt(reader.readLine());

        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++) System.out.print(8);
            System.out.println();
        }

    }
}
