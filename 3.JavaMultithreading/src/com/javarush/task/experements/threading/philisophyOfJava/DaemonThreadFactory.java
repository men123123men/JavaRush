package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}

