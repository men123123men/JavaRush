package com.javarush.task.task12.task1227;

/* 
Fly, Run, Swim для классов Duck, Penguin, Toad
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        void fly();
    }

    public interface Run {
        void run();
    }

    public interface Swim {
        void swim();
    }

    public class Duck implements Run,Swim,Fly{

        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Penguin implements Run, Swim{

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Toad implements Swim{

        @Override
        public void swim() {

        }
    }
}
