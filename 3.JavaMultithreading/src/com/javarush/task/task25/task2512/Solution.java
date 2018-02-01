package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        t.interrupt();
//        printStackTrace(e);
//    }
//    public void printStackTrace(Throwable e){
//        if(e.getCause()!=null)
//            printStackTrace(e.getCause());
//        System.out.printf("%s: %s%n",e.getClass().getName(),e.getMessage());
//    }
    public void uncaughtException(Thread t, Throwable e){
        t.interrupt();

        Stream.iterate(e,Throwable::getCause)
                .takeWhile(Objects::nonNull)
                .collect(LinkedList::new, LinkedList::addFirst, List::addAll)
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
//        Runnable runnable = ()->{ throw new RuntimeException("DEF", new IllegalArgumentException("GHI", new NumberFormatException("JKL"))); };
//        Thread thread = new Thread(runnable);
//        thread.setUncaughtExceptionHandler(new Solution());
//        thread.start();

        Thread.currentThread().setUncaughtExceptionHandler(new Solution());
        throw  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

//        Stream<String> strings = Stream.of("one", "two", "three", "four");
//
////        strings.collect(Collectors.toCollection(new Supplier<Collection<? extends Object>>() {...}))
////                .forEach(System.out::println);
//        strings.collect(LinkedList::new, LinkedList::addFirst,List::addAll).forEach(System.out::println);

    }
}
