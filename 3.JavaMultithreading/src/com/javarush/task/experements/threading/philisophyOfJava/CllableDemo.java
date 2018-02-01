package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CllableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Future[] futures = new Future[100];

        for(int i=0;i<futures.length;i++)
            futures[i] = service.submit(new TaskWithResult(i)); // выполнение callable'ов начинается здесь

//        for(Future f: futures)
//            System.out.println(f.isDone());
//    System.out.println();
//    Thread.sleep(71);
//        for(Future f: futures)
//            System.out.println(f.isDone());

        for(Future f: futures)
            System.out.println(f.get());  // возврвщение значения уже выполненного callable'а

        for(Future f: futures)
            System.out.println(f.get()); // метод блокирующий (можно вызвать get(int time)

        service.shutdown();
    }
}
