package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private Lock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = false;
        try {
            captured = lock.tryLock();
            System.out.println("tryLock(): " + captured);

        } finally {
            if (captured)
                lock.unlock();
        }
    }
    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2, TimeUnit.SECONDS);
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            if(captured)
                lock.unlock();
        }
    }

    public static void main(String[] args){
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            {setDaemon(true);}
            @Override
            public void run() {
                super.run();
                al.lock.lock();
                System.out.println("acqaired");
            }
        }.start();

        Thread.yield();
        al.untimed();
        al.timed();
    }



}
