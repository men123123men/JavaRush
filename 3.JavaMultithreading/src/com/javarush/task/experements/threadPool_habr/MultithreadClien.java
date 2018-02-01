package com.javarush.task.experements.threadPool_habr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultithreadClien {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int countOfProcessores = Runtime.getRuntime().availableProcessors();
        System.out.printf("There are %d processoroes in this system.%n",countOfProcessores);

        ExecutorService threadPool = Executors.newFixedThreadPool(countOfProcessores);
        Counter counter = new Counter();

        long start= System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();

        for(int i=0;i<200;i++){
            final int j=i;
            futures.add(CompletableFuture.supplyAsync(()->counter.count(j),threadPool));
        }

        double value = 0;
        for(Future<Double> future:futures)
            value+=future.get();

        System.out.printf("Время составило: %,d секунды %n",(System.nanoTime()-start)/1_000_000);

        threadPool.shutdown();
        int числоВычислительныхЯдер = Runtime.getRuntime().availableProcessors();
    }
}
