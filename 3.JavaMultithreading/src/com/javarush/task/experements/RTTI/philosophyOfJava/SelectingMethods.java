package com.javarush.task.experements.RTTI.philosophyOfJava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class SelectingMethods {
    public static void main(String[] args) {
        // реализация которую мы в последствии перехватим
        SomeMethods someMethods = new SomeMethods() {
            @Override
            public void boring1() { System.out.println("boring1"); }
            @Override
            public void boring2() { System.out.println("boring2"); }
            @Override
            public void interesting(String arg) { System.out.println("interesting " + arg); }
            @Override
            public void boring3() { System.out.println("boring3"); }
        };

        // реализация фигни которая перехватывает реальную это все дело
        InvocationHandler invocationHandler = (proxy, method, args1) -> {
            if(method.toString().contains("interesting")) // или так: method.getName().equals("interesting")
                System.out.println("Proxy detected the interesting method");
            return method.invoke(someMethods, args1); // делигируем изначальному объекту
        };

        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                someMethods.getClass().getClassLoader(),
                new Class[]{SomeMethods.class},
                invocationHandler
        );

        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}
