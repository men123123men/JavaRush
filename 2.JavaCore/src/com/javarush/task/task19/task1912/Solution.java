package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {


        PrintStream oldPS = System.out;

        ByteArrayOutputStream myOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));

        testString.printSomething();

        System.setOut(oldPS);

        System.out.println(myOut.toString().replace("te", "??"));



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
