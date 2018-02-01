package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {


        int number = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        String numberLenght = number + "";
        int numLenght = numberLenght.length();

        for (int i = 0; i < numLenght; i++) {
            if (((number%10) % 2 == 0) == true)
                even++;
            else odd++;

            number = number / 10;
        }

        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
