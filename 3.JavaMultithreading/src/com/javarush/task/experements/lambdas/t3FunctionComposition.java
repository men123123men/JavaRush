package com.javarush.task.experements.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class t3FunctionComposition {
    public static void main(String... args) {
        List<Integer> numrers = Arrays.asList(1, 2, (int) '3', 4, (int) '₽');

        numrers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                myPrint(integer);
            }
        });

//        Consumer<Integer> cons =i-> myPrint(i);
//        numrers.forEach(cons);

//        numrers.forEach(i->myPrint(i));

//        numrers.forEach(t3FunctionComposition::myPrint);




        Function<String,Integer> myFunc = Integer::parseInt;
        Integer myInt = myFunc.apply("355");
        System.out.println(myInt.equals(355));

        int mySecondInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }.apply("234");

        System.out.println(mySecondInt+766);



        User3 user0 = new UserFactory() {
            @Override
            public User3 create(String name, String surname) {
                return new User3(name,surname);
            }
        }.create("John", "Snow");

        UserFactory userFactory = User3::new;
        User3 user = userFactory.create("John", "Snow");




        Function<String,String> trim = String::trim;
        String str0 = new StringBuilder("     qwertyuiop     ".trim().toUpperCase()).reverse().toString();
        String str = trim
                .andThen(String::toUpperCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply("     qwertyuiop     ");
        System.out.println(str);


        BiFunction<String,String,User3> bif = User3::new;

        List<User3> users = Arrays.asList(bif.apply("Nick", "Boll"),bif.apply("Jan", "Nicky"),bif.apply("Bot", "Smart"));

        users.sort(Comparator.comparing(User3::getName));
        users.forEach(System.out::println);

    }
    public static void myPrint(int i){
        System.out.printf("myPrint :%5d %c%n",i,(char)i);
    }

}

class User3 {
    String name, surname;

    User3(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User3{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
interface UserFactory {
    User3 create(String name, String surname);
}