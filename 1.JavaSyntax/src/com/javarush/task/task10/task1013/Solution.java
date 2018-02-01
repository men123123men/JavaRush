package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

public static class Human {
    private static String name;
    private static String profession;
    private static int age;
    private static int sex;
    private static Human mama;
    private static Human papa;

    public Human(String name, int age, int sex) {  }
    public Human(String name, int age, int sex, String profession) {}
    public Human(String name, int age, String profession) {}
    public Human(String name, int sex) {}
    public Human(int age, int sex) {}
    public Human(int age, int sex, String profession) {}
    public Human(String name, int age, int sex, Human mama, Human papa) {}
    public Human(String name, Human mama) {}
    public Human(String name, int age, Human mama) {}
    public Human(String name, String profession, Human mama) {}
}
}
