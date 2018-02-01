package com.javarush.task.task18.task1801;

/*
Максимальный байт
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(sc.nextLine());
            int maxByte = Integer.MIN_VALUE;

            while( fileInputStream.available() > 0 )
                maxByte = Integer.max( fileInputStream.read() , maxByte );

            System.out.println( maxByte );

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        } finally{
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
