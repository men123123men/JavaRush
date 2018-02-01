package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat {
        public String getName(){return name;}
        public Cat getChild(){return child;}
        private String name;
        private Cat child;

    }

    public static class Dog {
        public String getName(){return name;}
        public Dog getChild(){return child;}
        private String name;
        private Dog child;

    }

}
