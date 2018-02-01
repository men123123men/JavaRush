package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader (new FileReader(consoleReader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter (new FileWriter(consoleReader.readLine()));

        while(fileReader.ready())
            fileWriter.write(fileReader.readLine().replaceAll( "[^\\w]", "" ));

        consoleReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
