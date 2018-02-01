package com.javarush.task.experements.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class t1Sorted {


    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21));

        System.out.println("Before sort:");

        users.forEach(System.out::println);



        Comparator<User> comp10 = Comparator.comparing(new Function<User, Integer>() {
            @Override
            public Integer apply(User user) {
                return user.getAge();
            }
        });
        Comparator<User> comp11 = Comparator.comparing(user -> user.getAge());
        Comparator<User> comp12 = Comparator.comparing(User::getAge);

        Comparator<User> comp20 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()-o2.getAge();
            }
        };
        Comparator<User> comp21 = (u1, u2) -> u1.getAge()-u2.getAge();

        Comparator<User> comp22 = Comparator.comparingInt(u->u.getAge());
        Comparator<User> comp23 = Comparator.comparingInt(User::getAge);


//        Collections.sort(users, comp11);
//        users.sort(comp10);

        System.out.println("\nAfter sort:");

        users.stream()
                .sorted((u1,u2)->u1.getAge()-u2.getAge())
                .forEach(System.out::println);



    }











static class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User3{name='" + name + "\', age=" + age + "}";
    }

    public int getAge() {

        return age;
    }
}
}