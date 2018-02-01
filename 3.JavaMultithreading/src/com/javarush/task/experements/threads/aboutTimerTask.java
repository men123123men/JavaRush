package com.javarush.task.experements.threads;

import java.util.Timer;
import java.util.TimerTask;

public class aboutTimerTask {
    public static void main(String[] args) throws InterruptedException {

        Thread sesondsPrint = new Thread(()->{
            int seconds = 0;
            while(!Thread.currentThread().isInterrupted()){

                System.out.println(++seconds+"ая секунда пошла");
                try {
                    //Thread.sleep(1000);
                    synchronized(Thread.currentThread()){
                        Thread.currentThread().wait(1000);
                    }

                } catch (InterruptedException e) {
                    System.out.println("Interrup'нули секундомер мой");
                    Thread.currentThread().interrupt();
                }

            }});
        sesondsPrint.start();



        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                new RunWork().run();
            }
        };

        Timer timer = new Timer("Какой-то таймер", false);

        timer.scheduleAtFixedRate(task, 1*1000, 3*1000);// (задача, начальная задержка, переиодичность);

        Thread.sleep(10*1000);

        timer.cancel();
        sesondsPrint.interrupt();




    }



}
