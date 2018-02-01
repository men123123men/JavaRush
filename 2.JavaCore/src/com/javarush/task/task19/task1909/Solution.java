package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader concoleReader = new BufferedReader(new InputStreamReader( System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(concoleReader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(concoleReader.readLine()));
        //Pattern point = Pattern.compile("//.");
char currentChar;
while(fileReader.ready()) {
    //fileWriter.write(fileReader.readLine().replaceAll("\\.","!"));
    currentChar =(char) fileReader.read();

    fileWriter.write(currentChar=='.'? '!' : currentChar);
}
        concoleReader.close();
        fileReader.close();
        fileWriter.close();

    }
}
