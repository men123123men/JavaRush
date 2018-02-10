package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods instance;
    public CustomInvocationHandler(SomeInterfaceWithMethods instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy,Method invokedMethod,Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println(invokedMethod.getName()+" in");
        Object invokedMethodResult  = invokedMethod.invoke(instance,args);
        System.out.println(invokedMethod.getName()+" out");
        return invokedMethodResult;


    }
}
