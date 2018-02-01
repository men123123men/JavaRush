package com.javarush.task.experements.RTTI.philosophyOfJava;

import java.util.Arrays;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    // Закомментируйте следующий далее конструктор по
    // умолчанию, тогда в строке с пометкой (*1*)
    // возникнет ошибка NoSuchMethodError
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1); }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Имя класса:       " + cc.getName());
        System.out.println("Это"+(cc.isInterface()?" ": " ННННЕЕЕЕ ")+"интерфейс!");
        System.out.println("Простое имя:      " + cc.getSimpleName());
        System.out.println("Каноническое имя: " + cc.getCanonicalName()+"\n");
    }
    public static void main(String[] args) {

//        Class c = FancyToy.class;
        Class c = null;
        try {
            c = Class.forName("com.javarush.task.experements.RTTI.philosophyOfJava.FancyToy");
        } catch(ClassNotFoundException e) {
            System.out.println("He найден класс FancyToy");
            System.exit(1);
        }
        printInfo(c);
//        for(Class face : c.getInterfaces())
//            printInfo(face);
        Arrays.stream(c.getInterfaces())
                .forEach(ToyTest::printInfo);

        Class up = c.getSuperclass();
        Object obj = null;

        Arrays.stream(up.getConstructors()).forEach(System.out::println);

//        try {
//            obj = up.getConstructor(int.class).newInstance(45);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


        try {
            // Необходим конструктор по умолчанию:
            obj = up.newInstance();
        } catch(InstantiationException e) {
            System.out.println("He удалось создать объект");
            System.exit(1);
        } catch(IllegalAccessException e) {
            System.out.println("Нет доступа");
            System.exit(1);
        }

        printInfo(obj.getClass());
    }
}
