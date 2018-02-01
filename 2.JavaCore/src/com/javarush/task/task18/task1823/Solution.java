package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        //ReadThread currentThread;
        while (!(fileName=scanner.nextLine()).equals("exit"))
            new ReadThread(fileName).start();

    }
    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            InputStream fis = null;
            Map<Character, Integer> charFrequency = new HashMap<>();
            char maxFrequencyChar=0;
            char currentChar;
            int maxCount=0;
            int currentCount;
            try{
                fis = new FileInputStream(fileName);
                while(fis.available()>0){
                    currentChar = (char) fis.read();
                    if(charFrequency.containsKey(currentChar)) {
                        currentCount = charFrequency.get(currentChar)+1;
                        charFrequency.replace(currentChar, currentCount);
                        if (currentCount>maxCount) {
                            maxCount = currentCount;
                            maxFrequencyChar = currentChar;
                        }
                    }
                    else
                        charFrequency.put(currentChar,1);
                }
                resultMap.put(Thread.currentThread().getName(),(int) maxFrequencyChar);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//
//        try {
//            int maxVal=0;
//            int maxKey;
//            Map<Integer, Integer> hashMap = new HashMap<>();
//            FileInputStream in = new FileInputStream(this.fileName);
//            while (in.available() > 0){
//                int nextByte = in.read();
//                if(hashMap.containsKey(nextByte)){
//                    int value = hashMap.get(nextByte) +1;
//                    hashMap.replace(nextByte,value);
//                    if(value > maxVal){
//                        maxVal = value;
//                        maxKey = nextByte;
//                    }
//                } else hashMap.put(nextByte,1);
//            }
//
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


        }
    }
}
