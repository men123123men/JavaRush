package com.javarush.task.task18.task1802;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        InputStream InStream = null;

        try {
            InStream = new FileInputStream(scanner.nextLine());
            int minByte = Integer.MAX_VALUE;
            while( InStream.available()>0 )
                minByte = Integer.min(minByte,InStream.read());
            System.out.println(minByte);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                InStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
