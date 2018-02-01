package com.javarush.task.experements.innerClasses.philosophyOfJava;

//: innerclasses/Parcel10.java
// Демонстрация "инициализации экземпляра" для
// конструирования безымянного внутреннего класса
public class Parcel10 {
    public Destination
    destination(String dest,float price) {
        return new Destination() {
            private int cost;

            { // типо вместо конструктора
                cost = Math.round(price);
                if(cost > 100)
                    System.out.println(cost+"\tOver budget!");
            }
            private String label = dest;
            @Override
            public String readLabel() { return label; }
        };
    }
    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}
