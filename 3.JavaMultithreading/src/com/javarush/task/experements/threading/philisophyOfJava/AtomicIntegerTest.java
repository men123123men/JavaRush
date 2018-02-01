package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable{

    private AtomicInteger i = new AtomicInteger(0);
    public int getValue(){return i.get();}
    private void evenIncrement(){ i.addAndGet(2);}
    @Override
    public void run() {
        while(true)
            evenIncrement();
    }

    public static void main(String[] args){

        ScheduledExecutorService stoper = Executors.newSingleThreadScheduledExecutor();
        stoper.schedule(()->System.exit(0),5, TimeUnit.SECONDS);

//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() { System.exit(0);}},5000);

        AtomicIntegerTest ait = new AtomicIntegerTest();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++)
            exec.execute(ait);

        int val;
        while (true)
            if ((val=ait.getValue()) % 2 != 0)
                System.out.println(val);
    }
}
