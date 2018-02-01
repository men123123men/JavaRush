package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String ded = reader.readLine();
        Cat catDed = new Cat(ded);

        String baba = reader.readLine();
        Cat catBaba = new Cat(baba);

        String papa = reader.readLine();
        Cat catPapa = new Cat(papa, catDed, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catBaba);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catPapa, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catPapa, catMother);

        System.out.println(catDed);
        System.out.println(catBaba);
        System.out.println(catPapa);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mama;
        private Cat papa;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat papa, Cat mama) {
            this.name = name;
            this.mama = mama;
            this.papa = papa;
        }

        @Override
        public String toString() {
            if ((mama == null) & (papa == null)) {
                return "Cat name is " + name + ", no mother " + ", no father ";
            } else if (mama == null)
                return "Cat name is " + name + ", no mother " + ", father is " + papa.name;
            else if (papa == null) {
                return "Cat name is " + name + ", mother is " + mama.name + ", no father ";
            } else {
                return "Cat name is " + name + ", mother is " + mama.name + ", father is " + papa.name;
            }
        }
    }

}