package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    private boolean started=false;
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true; // Ready to buff
            notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
            notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException {

        while(!waxOn)
            wait();

    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn)
            wait();
    }
    public synchronized void start() throws InterruptedException {
        while(started)
            wait();
        System.out.println("Стартую!\nЗакончил!");
        started = true;
        notifyAll();
    }
    public synchronized void stop() throws InterruptedException{
        while(!started)
            wait();
        System.out.println("\tОстанавливаю!");
        started=false;
        notifyAll();
    }

}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c) { car = c; }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
//                car.waitForBuffing();
//                System.out.println("\t\tWax On! ");
//                //TimeUnit.MILLISECONDS.sleep(20);
//                car.waxed();
                car.stop();

            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c) { car = c; }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
//                car.waitForWaxing();
//                System.out.println("Wax Off! ");
//                //TimeUnit.MILLISECONDS.sleep(20);
//                car.buffed();
                car.start();
            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.MILLISECONDS.sleep(25); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}
