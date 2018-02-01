package com.javarush.task.task25.task2505;

import java.util.function.Consumer;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {

    Consumer<Thread> printer =
            (t)->System.out.printf("%s отработал%n", t.getName());

        Runnable runner = ()-> {
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer.accept(Thread.currentThread());
        };

        Thread thr = new Thread(runner);
        thr.setDaemon(true); // делаем поток демоном
        thr.start();

        thr.join(); // заставляем main поток "ждать" завершения демон потока

        printer.accept(Thread.currentThread());

    }

    public class MyThread extends Thread {

        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false); // тут изначально было true
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println(
                        String.format("%s, %s, %s",MyThread.this.secretKey,t.getName(),e.getMessage()));
            }
        }
    }

}

