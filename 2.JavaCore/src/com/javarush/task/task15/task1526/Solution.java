package com.javarush.task.task15.task1526;

/* 
Дебаг, дебаг, и еще раз дебаг
*/

public class Solution {
    public static void main(String[] args) {
        new B(6);
    } // 0 9 -> 6 9

    public static class A {
        private int variableA = 7;

        public A(int argumentA) {
            variableA = argumentA;
            this.initialize();
        }

        private void initialize() {
            System.out.println(variableA);
        }
    }

    public static class B extends A {
        protected int variableB = 3;

        public B(int argumentB) {
            super(argumentB);
            variableB += argumentB;
            initialize();
        }

        //@Override
        protected void initialize() {
            System.out.println(variableB);
        }
    }
}
