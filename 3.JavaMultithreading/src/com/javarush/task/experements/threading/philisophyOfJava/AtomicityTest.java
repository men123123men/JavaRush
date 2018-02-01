package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private Integer i = 0;
    public  int getValue(){return i;}
    private synchronized void evenIncrement(){i++;i++;}
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted())
            evenIncrement();
    }
    public static void main(String[] args){
        ExecutorService service = Executors.newSingleThreadExecutor();
        AtomicityTest atomicityTest = new AtomicityTest();
//
        service.execute(atomicityTest);

        while(true){
            int val = atomicityTest.getValue();
            if(val%2!=0) {
                System.out.println(val);
                service.shutdownNow();
                break;
            }
        }
    }


}
