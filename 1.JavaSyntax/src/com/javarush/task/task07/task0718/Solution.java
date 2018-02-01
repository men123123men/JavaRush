package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> eneredStrs = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String currentStr;
        int lengthOfPrevious = 0;
        int position = -1;

        for(int i = 0;i<10;i++){

            currentStr = reader.readLine();
            eneredStrs.add(currentStr);

            if (currentStr.length()>=lengthOfPrevious)
                lengthOfPrevious = currentStr.length();
            else if (position==-1)
                position = i;
        }
        if (position!=-1) System.out.println(position);
    }
}

