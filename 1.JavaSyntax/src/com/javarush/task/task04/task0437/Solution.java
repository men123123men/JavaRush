package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/


public class Solution {
    public static void main(String[] args) throws Exception {

        int height = 10;
        int width = 10;

        for(int i =1;i<=height;i++){
            for (int j=0;j<i;j++) System.out.print(8);
            System.out.println();
        }

    }
}
