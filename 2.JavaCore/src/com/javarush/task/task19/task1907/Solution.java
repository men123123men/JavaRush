package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
public static void main(String[] args) throws IOException {
//        String fileName = null;
//        BufferedReader consoieReader = null;
//        try{
//            consoieReader = new BufferedReader(new InputStreamReader(System.in));
//            fileName = consoieReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                consoieReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//
//            Pattern regex = Pattern.compile("world");
//            int countOfWorlds=0;
//            while (fileReader.ready()){
//                Matcher text = regex.matcher(fileReader.readLine());
//                while (text.find())
//                    countOfWorlds++;
//            }
//            System.out.println(countOfWorlds);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    BufferedReader consoieReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader fileReader = new BufferedReader(new FileReader(consoieReader.readLine()));

    Pattern regex = Pattern.compile("\\bworld\\b");
    int countOfWorlds=0;
    while (fileReader.ready()){   //
        Matcher text = regex.matcher(fileReader.readLine());
        while (text.find())
            countOfWorlds++;
    }
    System.out.println(countOfWorlds);
    consoieReader.close();
    fileReader.close();
}
}
