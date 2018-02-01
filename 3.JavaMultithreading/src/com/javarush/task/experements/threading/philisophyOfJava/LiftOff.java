package com.javarush.task.experements.threading.philisophyOfJava;

public class LiftOff implements Runnable{
    protected int countDoun = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() { }
    public LiftOff(int countDoun) {
        this.countDoun = countDoun;
    }
    public String status(){
        return String.format("# %d (%s)",id,countDoun>0?countDoun:"LiftOff!");
    }

    @Override
    public void run(){
        while(countDoun-->0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
