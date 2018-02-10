package com.javarush.task.experements;

import java.util.Set;

public class DemoClass {

    public static void a() {
        b();
    }

    static void b() {
        c();
    }

    static void c() {
        d();
    }

    static void d() {

        Set<StackWalker.Option> options = Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE, StackWalker.Option.SHOW_HIDDEN_FRAMES);

        StackWalker.getInstance(options)
                .forEach(System.out::println);
    }
}