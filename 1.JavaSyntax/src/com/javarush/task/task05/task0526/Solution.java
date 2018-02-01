package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Man("Kost\'ia", 18,"Moscow"));
        System.out.println(new Man("Jen\'ia", 57,"Piter"));

        System.out.println(new Woman("Kost\'ia", 18,"Moscow"));
        System.out.println(new Woman("Jen\'ia", 57,"Piter"));
    }

    public static class Man {
        private String name;
        private int age;
        private String address;

        public String toString(){
            return (String) name+" "+age+" "+address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
        public static class Woman{
            private String name;
            private int age;
            private String address;

            public String toString(){
                return (String) name+" "+age+" "+address;
            }

            public Woman(String name, int age, String address){
                this.name = name;
                this.age = age;
                this.address = address;
            }
    }
}
