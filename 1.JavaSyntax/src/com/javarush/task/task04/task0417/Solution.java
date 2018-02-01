package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        if (num1==num2&&num2==num3) System.out.print(num1+" "+num2+" "+num3);
        else if (num1==num2) System.out.print(num1+" "+num2);
        else if (num2==num3) System.out.print(num2+" "+num3);
        else if (num1==num3) System.out.print(num1+" "+num3);


    }
}