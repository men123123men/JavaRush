package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String string = addContext(result);
        System.out.println(string);
    }
    private static String addContext(String result) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char[] ch = result.toCharArray();
        for (char c : ch) {
            builder.append(c);
            if (c == 10) count++;
            if (count == 2) {
                builder.append("JavaRush - курсы Java онлайн\n");
                count = 0;
            }
        }
        result = builder.toString();
        return result;
    }
    public static class MyPrintStream extends PrintStream{
        int counter = 0;
        public MyPrintStream(OutputStream out) { super(out); }
        @Override
        public void println(String x) {
            super.println(x);
            if(++counter%2==0)
                super.println("JavaRush - курсы Java онлайн");
        }
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
