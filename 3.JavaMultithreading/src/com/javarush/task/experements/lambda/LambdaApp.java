package com.javarush.task.experements.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;


public class LambdaApp {
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        for(Integer n: list)
            System.out.print(n+" ");                    System.out.println();       // Старый способ

        list.forEach(n -> System.out.print(n+" "));     System.out.println();       // Новый способ

        list.forEach(System.out::print);                System.out.println("\n\n"); // Новый способ с оператором ::







        Predicate<Integer> isPositive = x -> x > 0;                 // boolean test(T t)
        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false

        BinaryOperator<Integer> multiply = (x, y) -> x*y;           // T apply(T t1, T t2);
        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20

        UnaryOperator<Integer> square = x -> x*x;                   // T apply(T t);
        System.out.println(square.apply(5)); // 25

        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";    //  R apply(T t);  Function<T, R>
        System.out.println(convert.apply(5)); // 5 долларов

        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);     // void accept(T t);
        printer.accept(600); // 600 долларов

        Supplier<User> userFactory = ()->{                          // T get();

            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            //String name = in.nextLine();
            String name = "Мурзик";
            return new User(name);
        };
        User user1 = userFactory.get();
        User user2 = userFactory.get();
        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
    }

    static class User {

        private String name;
        String getName() { return name; }
        User(String n) { this.name = n; }
    }

}
