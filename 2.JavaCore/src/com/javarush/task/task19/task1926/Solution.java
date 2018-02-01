package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
public static void main(String[] args) throws IOException{
    BufferedReader reder = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader fr = new BufferedReader(new FileReader(reder.readLine())); //  "/Users/admin/Desktop/From.txt"

    String line;
    int lineLength;
    while(fr.ready()){
        line = fr.readLine();
        lineLength = line.length();
        for(int i =lineLength-1; i>=0; i--)
            System.out.print(line.charAt(i));
        System.out.println();
    }
    reder.close();
    fr.close();
}
}
