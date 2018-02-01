package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        // String name = "/Users/admin/Desktop/numbers.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
        Set<Integer> set = new TreeSet<>();

        while (reader.ready())
            set.add(Integer.parseInt(reader.readLine()));

        reader.close();

        for (Integer number : set)
            if (number % 2 == 0)
                System.out.println(number);
    }
}




