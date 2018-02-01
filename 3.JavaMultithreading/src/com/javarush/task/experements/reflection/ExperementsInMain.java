package com.javarush.task.experements.reflection;

public class ExperementsInMain {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {


        Class systemClass = System.class;
        System mySystem = (System) systemClass.newInstance();
        SecurityManager security = (SecurityManager) systemClass.getField("security").get(mySystem);
        security.checkAccess(Thread.currentThread());

    }

}
