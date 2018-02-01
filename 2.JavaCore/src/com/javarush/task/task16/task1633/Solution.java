package com.javarush.task.task16.task1633;

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = (thread, exception) ->
            System.out.println(thread.getName() + ": " + exception.getMessage());


    public static void main(String[] args) {


        Thread threadA = new TestedThread("Нить 1");
        Thread threadB = new TestedThread("Нить 2");

        TestedThread.setDefaultUncaughtExceptionHandler(handler);

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(String name) {
            setName(name);
            start();
        }
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");
            }
        }
    }

}
