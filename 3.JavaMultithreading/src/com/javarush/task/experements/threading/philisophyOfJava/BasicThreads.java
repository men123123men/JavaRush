package com.javarush.task.experements.threading.philisophyOfJava;

public class BasicThreads {
    public static void main(String[] args){
        new Thread(new LiftOff()).start();
        System.out.println("Waiting for LithOff!");
    }
}
