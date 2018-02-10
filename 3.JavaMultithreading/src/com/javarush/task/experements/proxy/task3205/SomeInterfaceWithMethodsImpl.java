package com.javarush.task.experements.proxy.task3205;

public class SomeInterfaceWithMethodsImpl implements SomeInterfaceWithMethods {
    @Override
    public void voidMethodWithoutArgs() {
        System.out.println("inside voidMethodWithoutArgs");
    }
    @Override
    public String stringMethodWithoutArgs() {
        System.out.println("inside stringMethodWithoutArgs");
        return null;
    }
    @Override
    public void voidMethodWithIntArg(int i) {
        System.out.println("inside voidMethodWithIntArg");
        voidMethodWithoutArgs();
    }
}
