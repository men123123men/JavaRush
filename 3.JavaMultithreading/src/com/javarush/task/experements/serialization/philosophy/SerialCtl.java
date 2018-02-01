package com.javarush.task.experements.serialization.philosophy;


//: io/SerialCtl.java
// Управление сериализацией с определением собственных
// методов writeObject() и readObject()
import java.io.*;

public class SerialCtl implements Serializable {
    private String a;
    private transient String b;
    public SerialCtl(String aa, String bb) {
        a = "Not Transient:\t" + aa;
        b = "Transient:\t\t" + bb;
    }
    public String toString() { return a + "\n" + b; }


    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String)stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);


        ByteArrayOutputStream buf= new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);


        // Now get it back:
        ByteArrayInputStream bais= new ByteArrayInputStream(buf.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bais);
        SerialCtl sc2 = (SerialCtl)in.readObject();


        System.out.println("\nAfter:\n" + sc2);
    }
}
