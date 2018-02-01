package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DaemonFromFactory {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ThreadFactory myThreadFactory = Thread::new;

        ThreadFactory defaultFhreadFactory = Executors.defaultThreadFactory();

        ThreadFactory threadFastory = new DaemonThreadFactory();



        ExecutorService executorService = Executors.newCachedThreadPool(myThreadFactory);

        List<Future<String>> futures = new ArrayList<>();

        for(int i =0;i<7;i++)
            futures.add(executorService.submit(new SleepingTask()));

        List<String> futureStrings = new ArrayList<>();
        for(Future<String> f:futures)
            futureStrings.add(f.get());
        futureStrings.forEach(System.out::println);

        executorService.shutdown();


    }
}
