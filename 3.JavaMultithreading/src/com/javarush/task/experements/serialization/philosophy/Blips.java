package com.javarush.task.experements.serialization.philosophy;

//: io/Blips.java
// Простая реализация интерфейса Externalizable... с проблемами.
import java.io.*;


class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip1.writeExternal");
    }
    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        System.out.println("Blip2 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip2.writeExternal");
    }
    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();

        File file = new File("/Users/admin/Downloads/20September/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/experements/serialization/philosophy","Blips.out");

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        System.out.println("Recovering b1:");
        b1 = (Blip1)in.readObject();
        // OOPS! Throws an exception:
        System.out.println("Recovering b2:");
        b2 = (Blip2)in.readObject();
    }
}
