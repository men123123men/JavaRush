package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
//            BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));
            BufferedReader reader1 = new BufferedReader(new FileReader("/Users/admin/Desktop/numbers.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("/Users/admin/Desktop/numbers2.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("/Users/admin/Desktop/numbers2.txt"));




            StringBuffer sb= new StringBuffer();
            while (reader1.ready())
                sb.append(reader1.readLine());

            Pattern pat = Pattern.compile("[0-9]+");
            Matcher matcher = pat.matcher(sb.toString());

            while (matcher.find()) {
                //  System.out.println(matcher.group());
                writer2.write(matcher.group());
                writer2.write(' ');

            }
            writer2.close();
            while (reader2.ready())
                System.out.println(reader2.readLine());

            reader.close();
            reader1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
