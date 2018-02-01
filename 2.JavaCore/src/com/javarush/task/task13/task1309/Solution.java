package com.javarush.task.task13.task1309;

/* 
Всё, что движется
*/

public class Solution {
    interface Movable{
        Double speed();

    }
    interface Flyable extends Movable{
        Double speed(Flyable flyable);
    }
    public static void main(String[] args) throws Exception {
    }
}