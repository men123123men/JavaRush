package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args){
        // newSingleThreadExecutor пока один runnablе не отработает, следующий не начнет выполняться FIFO
        // newCachedTgreadPool
        // newFixedThreadPool
        // newWorkStealingPool

        // newScheduledThreadPool
        // newSingleThreadScheduledExecuter

        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++)
            service.execute(new LiftOff());
        service.shutdown();
        // ждет окончания всех Runnable'ов и останавливает Thread'ы
        // service.execute(new LiftOff()); // throw new RejectedExecutionException() (rejected - непригодный)


    }
}
