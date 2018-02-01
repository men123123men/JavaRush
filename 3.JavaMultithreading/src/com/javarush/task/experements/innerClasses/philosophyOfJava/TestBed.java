package com.javarush.task.experements.innerClasses.philosophyOfJava;

//: innerclasses/TestBed.java
// Помещение тестового кода во вложенный класс.
// {main: TestBed$Tester}

public class TestBed {
    public void f() { System.out.println("f()"); }

    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }

}
