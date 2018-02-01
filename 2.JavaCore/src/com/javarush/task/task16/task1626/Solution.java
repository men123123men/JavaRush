package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
//        new Thread(new CountDownRunnable(), "Уменьшаем").start();
//        new Thread(new CountUpRunnable(), "Увеличиваем").start();

//        int x = 10 , y = 12, z = 3;// x = 10 , y = 12, z = 3
//        x += + y - x++ * z;
//        System.out.println(x); // -8 = x
//        z =--x - y * 5;
//        System.out.println(z); // -69=z x=-9
//        y /= x + 5 % z;
//        System.out.println(y); // -3 = y
//        z = x++ + y * 5;
//        System.out.println(z); // -24=z x=-8
//        x = y - x++ * z;
//        System.out.println(x); // -195=

        int x = 10 , y = 12, z = 3;
        System.out.println(x += + y - x * z);

        x = 10 ; y = 12; z = 3;
        System.out.println(x += + y - ++x * z);

        x = 10 ; y = 12; z = 3;
        System.out.println(x += + y - x++ * z);




    }

public static class CountUpRunnable implements Runnable{
    //Add your code here - добавь код тут
    private int countIndexUp;
    private Thread thr = Thread.currentThread();
    @Override
    public void run() {
        while (!thr.isInterrupted() & countIndexUp<number){
            try {
                countIndexUp++;
                System.out.println(this);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                thr.interrupt();
                continue;
            }
        }
    }
    public String toString() {
        return Thread.currentThread().getName() + ": " + countIndexUp;
    }
}


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
