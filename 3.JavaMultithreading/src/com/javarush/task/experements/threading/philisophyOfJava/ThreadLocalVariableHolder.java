package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {
    public static ThreadLocal<Integer> value = new ThreadLocal<>(){
        private Random random = new Random();
        @Override
        protected synchronized Integer initialValue(){
            return random.nextInt(1000);
        }
    };
    public static void increment(){ value.set(value.get()+1); }
    public static int get(){ return value.get(); }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int i =0;i<5;i++) {
            service.execute(new Accessor(i));
            Thread.sleep(100);
        }
        TimeUnit.SECONDS.sleep(3);
        service.shutdownNow();


    }

}
class Accessor implements Runnable{
    private final int id;
    public Accessor(int id) { this.id = id; }
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#"+id+": "+ThreadLocalVariableHolder.get();
    }
}
