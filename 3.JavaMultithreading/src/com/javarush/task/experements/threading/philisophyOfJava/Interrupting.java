package com.javarush.task.experements.threading.philisophyOfJava;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            //synchronized (this){ wait();}
            TimeUnit.SECONDS.sleep(100);

        } catch(InterruptedException e) {
            System.out.println("InterruptedException isInterrupted()=="+Thread.currentThread().isInterrupted());
        }
        //while (!Thread.currentThread().isInterrupted());
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Waiting for read():");
            System.in.read();

        } catch(IOException e) {
            if(Thread.currentThread().isInterrupted())
                System.out.println("Interrupted from blocked I/O isInterrupted()=="+Thread.currentThread().isInterrupted());
            else
                throw new RuntimeException(e);
        } catch (Throwable throwable){
            System.out.println(throwable.getMessage());
        } finally {
            System.out.println("Ну хоть это-то выведи");
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    // Never releases lock
    public synchronized void f() { while(true) Thread.yield(); }
    // Lock acquired by this thread
    public SynchronizedBlocked() { new Thread(this::f).start(); }
    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("\n--------\nInterrupting " + r.getClass().getSimpleName());
        f.cancel(true); // Interrupts if running
        System.out.printf("Interrupt sent to %s%n--------%n%n",r.getClass().getSimpleName());
    }
    public static void main(String[] args) throws Exception {
        //test(new SleepBlocked());
        //test(new IOBlocked());
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);

        System.out.println("Aborting with System.exit(0)");
        System.exit(0); // ... since last 2 interrupts failed
    }
}