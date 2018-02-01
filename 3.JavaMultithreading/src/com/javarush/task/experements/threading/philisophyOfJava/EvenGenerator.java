package com.javarush.task.experements.threading.philisophyOfJava;

public class EvenGenerator extends IntGenerator {
    {currentEvenValue = 0;}
    @Override
    public synchronized int next() {
        ++currentEvenValue; // Danger point here!
        //Thread.yield();

        notifyAll();
        try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }

        ++currentEvenValue;

        return currentEvenValue;
    }
    public static void main(String[] args) {
        IntGenerator generator = new EvenGenerator();
        EvenChecker.test(generator);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (generator){
            generator.notifyAll();
        }
    }
} /* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~

