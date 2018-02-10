package com.javarush.task.experements.proxy.fromLivejournal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        IPerson person = new Person();

        ClassLoader classLoader = person.getClass().getClassLoader();
        Class[] interfaces = person.getClass().getInterfaces();
        InvocationHandler invocationHandler = new NeverSleepingEye(person);

        IPerson personproxy = (IPerson) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);



//        System.out.println(Proxy.isProxyClass(personproxy.getClass()));
//        System.out.println(personproxy.getClass().getName());

        personproxy.setName("Гриша");
        String h  = personproxy.getName() ;
        personproxy.rename("Вася");


        System.out.println(divide(35,4));

    }
    public static int divide(int a, int b) {
        int c = a-b;
        int d = 0;
        while(c > 0){
            c = c - b;
            d++;
            System.out.println("Частное " + d);
            if(c < 0){
                System.out.println("Результат деления: " + d + "." + (c + b));
            }
        }
        return d;
    }


}
