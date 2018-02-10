package com.javarush.task.experements.proxy.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethodsImpl instance = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = instance.getClass().getClassLoader();
        Class[] interfaces = instance.getClass().getInterfaces();
        InvocationHandler invocationHandler = new CustomInvocationHandler(instance);
        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}