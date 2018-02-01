package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread myOunThread = new TestThread();
        myOunThread.start();
        Thread.sleep(20);
        myOunThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        int myOunVariable = 0;
        @Override
        public void run() {
            while (!isInterrupted()){
                myOunVariable++;
                try {
                    System.out.println(myOunVariable==1?"Едем":"едем");
                    sleep(0,1);
                } catch (InterruptedException e) {
                    System.out.println("Приехали!");
                    interrupt();
                }


            }

        }
    }
}