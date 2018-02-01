package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true)
                new ReadThread(scanner.nextLine());
        } catch (Exception e) { }
    }
    public static  class ReadThread extends Thread{
        private String fileName;
        public ReadThread(String name) {
            fileName = name;
        }

        @Override
        public void run() {
            InputStream fis=null;
            float value =(float) 6.0;
            float result =0;
            try {
                fis = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                result=value/0;
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
