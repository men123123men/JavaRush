package com.javarush.task.experements.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyGetter {

    public static <T> T getProxy(T object){
        Class             clazz             = object.getClass();
        ClassLoader       classLoader       =  clazz.getClassLoader();
        Class[]           interfaces        =  clazz.getInterfaces();
        InvocationHandler invocationHandler = (proxy, method, args) -> method.invoke(object,args);

        return (T) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
//         return clazz.cast(Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }



}
