package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    private String name, address, color;
    private int age , weight;

    public Cat(String name){
        this.name = name;
        this.weight = 10;
        this.age = 5;
        this.color = "red";
    }
    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "red";
    }
    public Cat(String name, int age){
        this.name = name;
        this.weight = 10;
        this.age = age;
        this.color = "red";
    }
    public Cat(int weight, String color){
        this.color = color;
        this.weight = weight;
        age = 5;

    }
    public Cat(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        age = 5;

    }
    public static void main(String[] args) {

    }
}
