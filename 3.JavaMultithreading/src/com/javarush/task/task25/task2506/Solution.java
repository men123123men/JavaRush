package com.javarush.task.task25.task2506;

import java.util.stream.Stream;

/*
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();

//        Thread.yield();
        target.start();  //NEW
//        Thread.yield();

        Thread.sleep(100); //RUNNABLE
//        Thread.yield();
        target.join(100);
        Thread.sleep(400);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);

//        List<StackTraceElement> stackTraceElementList =
//                new ArrayList<>(Arrays.asList(Thread.currentThread().getStackTrace()));
//        stackTraceElementList.forEach(System.out::println);

        Stream.of(Thread.currentThread().getStackTrace())
                .forEach(System.out::println);





    }


}
