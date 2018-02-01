package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int result = 0;
        if (b>0) result = a>0 ? 1 : 2 ;
        else     result = a<0 ? 3 : 4 ;
        if (a!=0&&b!=0) System.out.println(result);
    }
}
