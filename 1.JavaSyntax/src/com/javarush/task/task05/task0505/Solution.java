package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        Cat bursik = new Cat ("Bursic",5,20,80);
        Cat mursic = new Cat("Mursic",4,22,89);
        Cat kuska =  new Cat ("Kuska",6,23,46);
        System.out.println(bursik.name+(bursik.fight(mursic)?">":"<")+mursic.name);
        System.out.println(bursik.name+(bursik.fight(kuska)?">":"<")+kuska.name);
        System.out.println(mursic.name+(mursic.fight(kuska)?">":"<")+kuska.name);


    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
