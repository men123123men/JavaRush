package com.javarush.task.experements.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class aboutCallable {
    static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {

        Callable<String> callable = () -> {
            Thread.sleep(100);
            return String.format("%3d %s",count.incrementAndGet(),Thread.currentThread().getName());
        };
        ExecutorService service =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<String>> list = new ArrayList<>();

        for(int i=0; i< 100; i++){
            Future<String> future = service.submit(callable);
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                System.out.printf("%ta %<tb %<td %<tT.%<tL\t %s%n",new Date(),fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        service.shutdown();









//        List<Future<String>> futures =
//                Stream.generate(() -> callable)
//                        .map(service::submit)
//                        .collect(Collectors.toList());
//        for (Future<String> currentFuture : futures) {
//            try {
//                System.out.println(new Date() + "::" + currentFuture.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }





    }
}
