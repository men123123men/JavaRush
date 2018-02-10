package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());



    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        byte[] bytes = new byte[8];
        int min,max;
        Random random = new Random();
        for(int i=0;i<bytes.length;i++){
            if(i<3)      { min = 'A' ; max = 'Z'; }
            else if(i<6) { min = 'a' ; max = 'z'; }
            else         { min = '0' ; max = '9'; }
            bytes[i] = (byte) random.ints(1,min,max).sum();
        }
        result.write(bytes);
        return result;
    }
}