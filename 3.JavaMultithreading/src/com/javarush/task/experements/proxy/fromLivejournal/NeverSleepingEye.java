package com.javarush.task.experements.proxy.fromLivejournal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NeverSleepingEye implements InvocationHandler {
    private Object obj;

    public NeverSleepingEye(Object f1){ obj = f1; }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(this.getClass().getSimpleName()+" "+proxy.getClass().getSimpleName()+" invoke : " + method.getName());
        return method.invoke(obj, args) ;
    }
}
