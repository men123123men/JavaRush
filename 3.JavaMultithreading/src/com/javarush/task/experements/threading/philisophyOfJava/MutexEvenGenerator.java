package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {
    {currentEvenValue=0;}
    Lock look = new ReentrantLock();
    @Override
    public int next() {
        look.lock();
        try{
            currentEvenValue++;
            currentEvenValue++;
            return currentEvenValue;
        }finally {
            look.unlock();
        }
    }
    public static void main(String[] args){
        EvenChecker.test(new MutexEvenGenerator());
    }
}
