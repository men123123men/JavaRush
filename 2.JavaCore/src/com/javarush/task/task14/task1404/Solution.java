package com.javarush.task.task14.task1404;

/* 
Коты
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for (String current=scanner.nextLine();!"".equals(current);current=scanner.nextLine())
            System.out.println(CatFactory.getCatByKey(current));
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            switch (key){
                case "vaska":   cat = new   MaleCat("Василий"); break;
                case "murka":   cat = new FemaleCat("Мурочка"); break;
                case "kiska":   cat = new FemaleCat("Кисюлька");break;
                default:        cat = new       Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;
        protected Cat(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }
        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }
        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
