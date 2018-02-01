package com.javarush.task.experements.serialization.philosophy;

import java.io.*;
import java.lang.reflect.Constructor;

class Alien implements Serializable {}

class Example{
    private int i;
    public Example(int i) {
        this.i = i;
    }
}

//class FreezeAlien {
//    public static void main(String[] args) throws Exception {
//
//    }
//}

public class AlienMain {
    public static void main(String[] args) throws Exception {

        File file = new File("/Users/admin/Downloads/20September/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/experements/serialization/philosophy", "alien.txt");


        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
        Alien quellek = new Alien();
        Alien myOunAlien = Alien.class.newInstance();


        //Alien ererere = Alien.class.getDeclaredConstructor(new Class[]{void.class}).newInstance();
        //System.out.println(ererere);

        Constructor[] constructors = Alien.class.getConstructors();
        System.out.println(constructors.length);

        Example excxc = Example.class.getDeclaredConstructor(new Class[]{int.class}).newInstance(45);
        System.out.println(excxc);

        out.writeObject(quellek);
        out.close();

        ObjectInputStream in = new ObjectInputStream( new FileInputStream(file));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass().getSimpleName());

        printNumber(5467);
        System.out.println();
        Constructor[] constructors1 = System.class.getDeclaredConstructors();
        System.out.println(constructors1[0].getExceptionTypes().length);

        String str = "INT";
        String str2 = str.toLowerCase();

        System.out.println(str2.equals("int"));


    }

public static void printNumber(int number){
    if (number>10)printNumber(number/10);
    System.out.print(number%10);
}


}