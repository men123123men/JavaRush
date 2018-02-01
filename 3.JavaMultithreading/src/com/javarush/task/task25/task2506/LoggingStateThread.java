package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread innerThread;
    public LoggingStateThread(Thread target) {
        super(target);
        innerThread =  target;
    }

    @Override
//    public void run() {
////        State cache = null;
//        State current;
//        while (!isInterrupted()){
//
//            current = innerThread.getState();
////            if (current!=cache){
//                System.out.println(current);
////                cache=current; }
//            //System.out.println("123");
//            if (current == State.TERMINATED)
//                interrupt();
//        }
//    }
    public void run() {
        State currentState = innerThread.getState();
        System.out.println(currentState);

        while (currentState!=State.TERMINATED){
            State newState = innerThread.getState();
            if (currentState!=newState){
                System.out.println(newState);
                currentState = newState;
            }
        }
    }
}
