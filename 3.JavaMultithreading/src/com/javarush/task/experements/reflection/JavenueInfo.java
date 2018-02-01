package com.javarush.task.experements.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JavenueInfo {
    private int field;
    public JavenueInfo(Object field) { }
    @Deprecated
    protected static void method(String[] params) { }
}

class Reflect {
    public static void main(String[] args) {
        Class clazz = JavenueInfo.class;

        // выводим название пакета
        Package p = clazz.getPackage();
        System.out.println("package " + p.getName() + ";");

        // начинаем декларацию класса с модификаторов
        int modifiers = clazz.getModifiers();
        System.out.print(getModifiers(modifiers));
        // выводим название класса
        System.out.print("class " + clazz.getSimpleName() + " ");

        // выводим название родительского класса
        System.out.print("extends " + clazz.getSuperclass().getSimpleName() + " ");

        // выводим интерфейсы, которые реализует класс
        Class[] interfaces = clazz.getInterfaces();
        for (int i = 0, size = interfaces.length; i < size; i++) {
            System.out.print(i == 0 ? "implements " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println(" {");

        // выводим поля класса
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t" + getModifiers(field.getModifiers())
                    + getType(field.getType()) + " " + field.getName() + ";");
        }

        // выводим констукторы класса
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.print("\t" + getModifiers(c.getModifiers()) +
                    clazz.getSimpleName() + "(");
            System.out.print(getParameters(c.getParameterTypes()));
            System.out.println(") { }");
        }

        // выводим методы класса
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            // получаем аннотации
            Annotation[] annotations = m.getAnnotations();
            System.out.print("\t");
            for (Annotation a : annotations)
                System.out.print("@" + a.annotationType().getSimpleName() + " ");
            System.out.println();

            System.out.print("\t" + getModifiers(m.getModifiers()) +
                    getType(m.getReturnType()) + " " + m.getName() + "(");
            System.out.print(getParameters(m.getParameterTypes()));
            System.out.println(") { }");
        }

        System.out.println("}");
    }

    static String getModifiers(int m) {
//        String modifiers = "";
//        if (Modifier.isPublic(m)) modifiers += "public ";
//        if (Modifier.isProtected(m)) modifiers += "protected ";
//        if (Modifier.isPrivate(m)) modifiers += "private ";
//        if (Modifier.isStatic(m)) modifiers += "static ";
//        if (Modifier.isAbstract(m)) modifiers += "abstract ";
//        return modifiers;
        return Modifier.toString(m);
    }

    static String getType(Class clazz) {
        return clazz.isArray() ? clazz.getComponentType().getSimpleName() + "[]" : clazz.getSimpleName();
    }

    static String getParameters(Class[] params) {
        String p = "";
        for (int i=0, size=params.length; i<size; i++) {
            if (i > 0) p += ", ";
            p += getType(params[i])+" param"+i;
        }
        return p;
    }
}

