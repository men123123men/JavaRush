package com.javarush.task.task13.task1305;

public class Solution {

    public static void main(String[] args) throws Exception {

        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie().toString());

    }

    interface Desire {
    }



    static  class Hobbie implements Desire, Dream {
        static int INDEX = 1;

        @Override
        public String toString() {
            return "" + ++INDEX;
        }
    }
}
