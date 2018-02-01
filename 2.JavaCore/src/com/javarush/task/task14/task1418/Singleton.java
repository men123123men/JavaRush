package com.javarush.task.task14.task1418;

public class Singleton {
    private Singleton(){}
    private static Singleton insstance;
    static Singleton getInstance(){
        return (insstance==null)? insstance = new Singleton() : insstance;
    }
}
