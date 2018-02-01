package com.javarush.task.experements.threading.philisophyOfJava;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call(){
        return String.format("result of TaskWithResult %d in %s",id,Thread.currentThread().getName());
    }

}
