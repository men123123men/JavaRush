package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        Matcher wordsMatcher = Pattern.compile("\\w*[a-zA-Z]\\w*").matcher("");
        Matcher digitMatcher = Pattern.compile("\\d").matcher("");
        String word;
        while (fr.ready()){
            wordsMatcher.reset(fr.readLine());
            while (wordsMatcher.find()) {
                word = wordsMatcher.group();
                digitMatcher.reset(word);
                if (digitMatcher.find())
                    fw.write(word+" ");
            }
        }
        fr.close();
        fw.close();

    }
}
