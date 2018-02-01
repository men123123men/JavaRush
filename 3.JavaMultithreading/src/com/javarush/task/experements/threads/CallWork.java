package com.javarush.task.experements.threads;

import java.util.concurrent.Callable;

public class CallWork implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int counter=10;
        for(int i=1;i<=counter;i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return counter;
    }
}
