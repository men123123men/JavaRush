package com.javarush.task.experements.serialization.philosophy;


//: io/MyWorld.java
import java.io.*;
import java.util.*;


class House implements Serializable {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }
}

class Animal implements Serializable {
    private String name;
    private House preferredHouse;
    Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }
    public String toString() {
        return "\n"+name + "[" + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) +
                "], " + preferredHouse ;
    }
}

public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco the dog     ", house));
        animals.add(new Animal("Ralph the hamster ", house));//
        animals.add(new Animal("Molly the cat     ", house));
        System.out.println("animals: " + animals+"\n");



        ByteArrayOutputStream buf1 =  new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals); // Write a 2nd set

        ObjectInputStream in1 = new ObjectInputStream( new ByteArrayInputStream(buf1.toByteArray()));
        List animals1 = (List)in1.readObject();
        List animals2 = (List)in1.readObject();
        System.out.println("animals1: " + animals1);
        System.out.println("animals2: " + animals2);



        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);

        ObjectInputStream in2 = new ObjectInputStream( new ByteArrayInputStream(buf2.toByteArray()));
        List animals3 = (List)in2.readObject();
        System.out.println("animals3: " + animals3);
    }
}
