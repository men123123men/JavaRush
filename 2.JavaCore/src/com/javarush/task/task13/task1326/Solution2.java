package com.javarush.task.task13.task1326;

import java.io.*;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //        InputStream inStream = new FileInputStream(reader.readLine());
        InputStream inStream = new FileInputStream("/Users/admin/Desktop/numbers.txt");
        BufferedReader numdersReader = new BufferedReader(new InputStreamReader(inStream));
        numdersReader.lines()
                .mapToInt(Integer::parseInt)
                .filter(i->i%2==0)
                .sorted()
                .forEach(System.out::println);
        inStream.close();
    }
}
