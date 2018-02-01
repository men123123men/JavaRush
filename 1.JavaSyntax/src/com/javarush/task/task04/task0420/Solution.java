package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int num[] = new int[3];
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(reader.readLine());
            sum+=num[i];
        }

        int minNum = num[0]<num[1]? ( num[0]<num[2] ? num[0] : num[2] ) : ( num[1]<num[2] ? num[1] : num[2] );
        int maxNum = num[0]>num[1]? ( num[0]>num[2] ? num[0] : num[2] ) : ( num[1]>num[2] ? num[1] : num[2] );

        System.out.println(maxNum+" "+(sum-minNum-maxNum)+" "+minNum);

    }
}
