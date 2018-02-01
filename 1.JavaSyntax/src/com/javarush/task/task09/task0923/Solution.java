package com.javarush.task.task09.task0923;

/*
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String userEnter = reader.readLine();

        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> consonants = new ArrayList<>();

        for (char currentChar:  userEnter.toCharArray()) {
            if (isVowel(currentChar))
                vowels.add(currentChar);
            else if(currentChar!=' ')consonants.add(currentChar);
        }
        for (char currentVowel: vowels)
            System.out.print(currentVowel+" ");
        System.out.println();
        for (char currentConsonant: consonants)
            System.out.print(currentConsonant+" ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
            if (c == d)
                return true;

        return false;
    }
}