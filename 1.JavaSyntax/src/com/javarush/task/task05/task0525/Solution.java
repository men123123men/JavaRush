package com.javarush.task.task05.task0525;

/* 
И целой утки мало
*/

public class Solution {

    public static void main(String[] args) {
        Duck duck1 = new Duck();
        Duck duck2 = new Duck();
        System.out.println(duck1);
        System.out.println(duck2);

        System.out.println(new Dog());
        System.out.println(new Dog());

        System.out.println(new Cat());
        System.out.println(new Cat());
    }

    public static class Duck {
        public String toString() {
            return "Duck";
        }
    }

    public static class Dog {
        public String toString(){ return  "Dog"; }
    }
    public static class Cat {
        public  String toString() {return "Cat";}
    }
}
