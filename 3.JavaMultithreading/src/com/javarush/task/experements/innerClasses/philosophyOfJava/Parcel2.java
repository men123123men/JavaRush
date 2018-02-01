package com.javarush.task.experements.innerClasses.philosophyOfJava;

public class Parcel2 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }
    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents();
    }
    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");

        // Defining references to inner classes:
        Parcel2 q = new Parcel2();
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");

        // Для создания экземпляра внутреннего класса
        // необходимо использовать экземпляр внешнего класса
        Parcel2 r = new Parcel2();
        Parcel2.Contents e = p.new Contents();
        Parcel2.Destination f = p.new Destination("Tasmania");

        //Parcel2.Contents g = new Parcel2().new Contents();

    }
}
