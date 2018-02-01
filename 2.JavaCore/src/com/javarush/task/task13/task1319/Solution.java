package com.javarush.task.task13.task1319;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        String line;
        while (true){
            line = reader.readLine();
            writer.write(line);
            if(line.equals("exit")) break;
            writer.write("\n");
        }
        reader.close();
        writer.close();
    }
}
