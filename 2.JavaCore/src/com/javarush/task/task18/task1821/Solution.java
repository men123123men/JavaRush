package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {

        InputStream fis = new FileInputStream(args[0]);  //  args[0]
        //InputStream fis = new FileInputStream("/Users/admin/Desktop/красивые шрифты на мак.txt");  //
        Map<Character, Integer> charFrequency = new HashMap<>();
        char currentChar;
        while(fis.available()>0) {
            currentChar = (char) fis.read();
            if (charFrequency.containsKey(currentChar))
                charFrequency.replace(currentChar, charFrequency.get(currentChar) + 1);
            else
                charFrequency.put(currentChar, 1);
        }
        fis.close();
//        final Map<Character, Integer> finalCharFrequency = charFrequency;
       //charFrequency.keySet().forEach(k-> System.out.println(k+" "+charFrequency.get(k)));
//       charFrequency.forEach((k,v)-> System.out.println(k+" "+v));
//        for(Map.Entry<Character, Integer> charFrequencyElement: charFrequency.entrySet())
//            System.out.println(charFrequencyElement.getKey()+" "+charFrequencyElement.getValue());
        charFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));


    }
}
