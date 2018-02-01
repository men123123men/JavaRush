package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream oldPrintStream = System.out;

        ByteArrayOutputStream myOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        testString.printSomething();
        System.setOut(oldPrintStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream fos = new FileOutputStream(reader.readLine());
        //fos.write(myOut.toByteArray());

        myOut.writeTo(fos);

        fos.close();
        reader.close();
        System.out.println(myOut.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

