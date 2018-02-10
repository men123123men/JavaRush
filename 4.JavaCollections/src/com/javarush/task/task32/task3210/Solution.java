package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {

        RandomAccessFile raf = new RandomAccessFile("/Users/admin/Desktop/Persons 2", "rw");
        byte[] bytes = readAllBytes(raf);
        System.out.println(new String(bytes));

    }

    public static byte[] readAllBytes(RandomAccessFile input) throws IOException {
        int bufferSize = 10;
        byte[] result = new byte[0];
        byte[] buffer = new byte[bufferSize];
        int countOfReadBytes;

        while ((countOfReadBytes = input.read(buffer, 0, buffer.length)) > 0) {
            byte[] newResult = new byte[result.length + countOfReadBytes];
            System.arraycopy(result, 0, newResult, 0, result.length);
            System.arraycopy(buffer, 0, newResult, result.length, countOfReadBytes);
            result = newResult;
        }

        return  result;
    }



}
