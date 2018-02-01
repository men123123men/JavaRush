package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SleepingTask implements Callable<String> {
    static int count;
    final int id = count++;

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return String.format("Callable %d отработал в %s",id,Thread.currentThread().getName());
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService service = Executors.newFixedThreadPool(2);

        List<Future<String>> futures = new ArrayList<>();

        for(int i=0;i<5;i++)
            futures.add(service.submit(new SleepingTask()));

        for(Future f: futures)
            System.out.println(f.get());

        service.shutdown();

    }

}
