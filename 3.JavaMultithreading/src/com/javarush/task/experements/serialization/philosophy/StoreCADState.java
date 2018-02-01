package com.javarush.task.experements.serialization.philosophy;

import java.io.*;
import java.util.*;

abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();
    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }
    public String toString() {
        return "\n"+getClass().getSimpleName() +
                "\tcolor[" + getColor() + "] xPos[" + xPos +
                "] yPos[" + yPos + "] dim[" + dimension + "]";
    }
    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim  = rand.nextInt(100);
        switch(counter++ % 3) {
            default:
            case 0: return new Circle(xVal, yVal, dim);
            case 1: return new Square(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }
}

class Circle extends Shape {     // для этого 1 (до десериализации эта переменная уже в классе)
    private static int color = RED; // это 1
    public Circle(int xVal, int yVal, int dim) { super(xVal, yVal, dim); }
    @Override
    public void setColor(int newColor) { color = newColor; }
    @Override
    public int getColor() { return color; }
}

class Square extends Shape {// для этого 0 (т.е. int по-умолчанию, т.к. конструктор не вызывается)
    private static int color;
    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;             // это 1
    }
    @Override
    public void setColor(int newColor) { color = newColor; }
    @Override
    public int getColor() { return color; }
}

class Line extends Shape {  // для этого 3  (т.к. принудительно записываем это поле сами)
    private static int color = RED;     // это 1
    public static void serializeStaticState (ObjectOutputStream os) throws IOException { os.writeInt(color); }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException { color = os.readInt(); }
    public Line(int xVal, int yVal, int dim) { super(xVal, yVal, dim); }
    @Override
    public void setColor(int newColor) { color = newColor; }
    @Override
    public int getColor() { return color; }
}

public class StoreCADState {
    public static void main(String[] args) throws Exception {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        shapeTypes.add(Circle.class);                   // Add references to the class objects:
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();
        for(int i = 0; i < 10; i++)                     // Make some shapes:
            shapes.add(Shape.randomFactory());

        for(int i = 0; i < 10; i++)                    // Set all the static colors to GREEN:
            ((Shape)shapes.get(i)).setColor(Shape.GREEN);  // это 3



        // Save the state vector:
        File file = new File("/Users/admin/Downloads/20September/JavaRushTasks/3.JavaMultithreading/" +
                "src/com/javarush/task/experements/serialization/philosophy", "CADState.txt");
        ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(file));

//        out.writeObject(shapeTypes);

        Line.serializeStaticState(out);

        out.writeObject(shapes);

        // Display the shapes:
        System.out.println(shapes);
    }
}