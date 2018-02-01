package com.javarush.task.experements.lambdas;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ReversStream implements Thread.UncaughtExceptionHandler {


//    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        t.interrupt();
//        printTrace(e);
//    }
//    public void printTrace(Throwable e){
//        if(e.getCause()!=null)
//            printTrace(e.getCause());
//        System.out.println(e);
//    }

    @Override
    public void uncaughtException(Thread t, Throwable e){
        t.interrupt();

        Stream.iterate(e, Objects::nonNull, Throwable::getCause)
                .collect(LinkedList::new, LinkedList::addFirst, List::addAll)
                .forEach(System.out::println);

    }

//    @Override
//    public void uncaughtException(Thread t, Throwable e){
//        t.interrupt();
//
//        List<Throwable> throwables = Stream.iterate(e,Throwable::getCause)
//                .takeWhile(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        ListIterator<Throwable> iterator = throwables.listIterator(throwables.size());
//        while (iterator.hasPrevious())
//            System.out.println(iterator.previous());
//    }

//    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        t.interrupt();
//        Stream.iterate(e, Throwable::getCause)
//                .takeWhile(Objects::nonNull)
//                .collect(Collectors.toCollection(LinkedList::new))
//                .descendingIterator()
//                .forEachRemaining(System.out::println);
//    }

    public static void main(String[] args) throws Exception {


        Thread.currentThread().setUncaughtExceptionHandler(new ReversStream());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

//        Runnable runnable = ()->{
//            throw new RuntimeException("DEF", new IllegalArgumentException("GHI", new NumberFormatException("JKL")));
//        };
//        Thread thread = new Thread(runnable);
//        thread.setUncaughtExceptionHandler(new ReversStream());
//        thread.start();
    }
}

