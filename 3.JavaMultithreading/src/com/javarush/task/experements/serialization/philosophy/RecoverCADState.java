package com.javarush.task.experements.serialization.philosophy;

//: io/RecoverCADState.java
// Восстановление состояния вымышленной системы CAD.
// {RunFirst: StoreCADState}
import java.io.*;
import java.util.*;

public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        File file = new File("/Users/admin/Downloads/20September/JavaRushTasks/3.JavaMultithreading/" +
                "src/com/javarush/task/experements/serialization/philosophy", "CADState.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

//        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>)in.readObject();

        Line.deserializeStaticState(in);


        List<Shape> shapes = (List<Shape>)in.readObject();
        System.out.println(shapes);
    }
}