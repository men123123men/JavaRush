package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
//        SomeInterfaceWithMethods obj = getProxy();
//        obj.stringMethodWithoutArgs();
//        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */

        List<Integer> integers = new ArrayList<>();
        List<Integer> proxyInts = getProxy(integers);

        proxyInts.add(1);
        proxyInts.add(5);
        proxyInts.add(99);

        System.out.println(proxyInts.size());



        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, Comparator.naturalOrder());

        System.out.println(names);






    }

//    public static SomeInterfaceWithMethods getProxy() {
//        SomeInterfaceWithMethodsImpl instance = new SomeInterfaceWithMethodsImpl();
//        ClassLoader classLoader = instance.getClass().getClassLoader();
//        Class[] interfaces = instance.getClass().getInterfaces();
//        InvocationHandler invocationHandler = new CustomInvocationHandler(instance);
//        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
//    }



    public static <T> T getProxy(T o){
        Class clazz = o.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
        Class[] interfaces = clazz.getInterfaces();
        InvocationHandler invocationHandler = (proxy, method, args)-> {
            System.out.printf("Method %s is invoking %n",method.getName());
            Object methodResult = method.invoke(o,args);
            System.out.printf("After doing of %s method %n",method.getName());
            return methodResult;
        };
        return (T) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }





}