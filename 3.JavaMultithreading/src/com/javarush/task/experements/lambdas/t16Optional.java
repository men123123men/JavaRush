package com.javarush.task.experements.lambdas;

import java.util.Optional;

public class t16Optional {
    public static void main(String[] args){

        Optional<String> name = Optional.of("Jone");

        System.out.println(name);

        if (name.isPresent())      //условие выполнится и мы увидим имя
            System.out.println(name.get()); //output John

        name.ifPresent(System.out::println);

        System.out.println(name.orElse("black"));




        System.out.println("--------------------------------------------");



        Optional<String> empty = Optional.empty();

        System.out.println(empty);

        if(empty.isPresent())
            System.out.println(empty.get());

        empty.ifPresent(System.out::println);

        System.out.println(empty.orElse("black"));






    }
}
