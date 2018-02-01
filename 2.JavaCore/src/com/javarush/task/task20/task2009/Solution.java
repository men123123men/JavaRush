package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
public static class ClassWithStatic implements Serializable{
    public static String staticString = "it's test static string";
    public int i;
    public int j;
    //      /*
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(staticString);
    }
    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        staticString = (String) stream.readObject();
    }
    //      */
}
public static void main(String[] args) throws IOException, ClassNotFoundException {

    File objectFile = File.createTempFile("objectWhithStaticFild.bin",null);
    System.out.println(objectFile.getCanonicalPath());      // чтобы посмотреть где этот файл создался
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile));
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));

    ClassWithStatic first = new ClassWithStatic();
    first.staticString = "Changed string";
    oos.writeObject(first);
    oos.close();
    first.staticString = "Опять поменяли строку";


    ClassWithStatic second = (ClassWithStatic) ois.readObject();
    System.out.println(second.staticString);
    ois.close();
}

}
