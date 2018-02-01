package com.javarush.task.experements.threading.philisophyOfJava;

public abstract class IntGenerator {
    protected int currentEvenValue;
    private volatile boolean canceled = false;
    public abstract int next() ;
    // Allow this to be canceled:
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }

} ///:~
