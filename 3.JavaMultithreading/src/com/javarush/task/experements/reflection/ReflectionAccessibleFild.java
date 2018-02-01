package com.javarush.task.experements.reflection;

import java.lang.reflect.Field;

class Inaccessible {
    private int field=6699;
    public String toString() {
        return field + "";
    }
}

class ReflectionAccessibleFild {
    public static void main(String[] args) throws Exception {
        Inaccessible o = new Inaccessible();
        System.out.println(o);

        Field field = o.getClass().getDeclaredField("field");
        field.setAccessible(true);
        field.set(o, 10);
        System.out.println(field.get(o)+" <- чтение измененного private поля");
        field.setAccessible(false);

        System.out.println(o);


    }
}