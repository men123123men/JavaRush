package com.javarush.task.experements.RTTI.philosophyOfJava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("\t\t**** proxy. %s, method { %-42s }, args %8s%n",
                proxy.getClass().getSimpleName(), method.toString().replaceAll("\\w+\\.",""), Arrays.toString(args));
//        if(args != null)
//            for(Object arg : args)
//                System.out.println(" " + arg);
        return method.invoke(proxied, args);
//        return "return";
    }
}

class SimpleDynamicProxy {

    public static void consumer(Interface іface) {
        іface.doSomething();
        іface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        // Вставляєм посредника и вызываем снова:
        Interface proxy = (Interface) Proxy.newProxyInstance(

                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}