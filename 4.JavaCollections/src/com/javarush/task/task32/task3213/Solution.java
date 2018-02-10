package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Collectors;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0

//        StringWriter


    }

    public static String decode(StringReader reader, int key){
        String result = "";
        try {
            result = new BufferedReader(reader).readLine().codePoints()
                    .map(i -> i + key)
                    .mapToObj(Character::toChars)
                    .map(String::new)
                    .collect(Collectors.joining());
        } finally {
            return result;
        }
    }
}
