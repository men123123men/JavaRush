package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> enteredStrs =new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        for(int i = 0; i < n; i++)
            enteredStrs.add(reader.readLine());

        Collections.rotate(enteredStrs,n-m);

        for (String currentStr: enteredStrs)
            System.out.println(currentStr);



    }
}
