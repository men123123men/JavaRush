package com.javarush.task.experements.threads;

public class RunWork implements Runnable {
    @Override
    public void run() {
        int counter=10;
        for(int i=1;i<=counter;i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
