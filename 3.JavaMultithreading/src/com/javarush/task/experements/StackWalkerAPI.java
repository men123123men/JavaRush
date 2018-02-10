package com.javarush.task.experements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StackWalkerAPI {

    public static void main(String[] args) {
        try {
//            DemoClass ds = new DemoClass();
            Method methodA = Class.forName("com.javarush.task.experements.DemoClass").getMethod("a");
            methodA.invoke(null, (Object[]) null);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | SecurityException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException ex) {
            Logger.getLogger(StackWalkerAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
