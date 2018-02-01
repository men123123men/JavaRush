package com.javarush.task.experements.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class adoutFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Thread thread = new Thread(new RunWork());
        thread.start();

        FutureTask<Integer> integerFutureTask = new FutureTask<>(new CallWork());
        Thread thread1 = new Thread(integerFutureTask);
        thread1.start();


        int result = integerFutureTask.get();
        System.out.println("Result is: "+ result);




    }
}
