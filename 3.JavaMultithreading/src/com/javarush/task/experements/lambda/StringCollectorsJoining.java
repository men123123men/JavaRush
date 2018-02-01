package com.javarush.task.experements.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringCollectorsJoining {
    public static void main(String[] args) {

        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("John");
        joiner.add("Danny");
        joiner.add("Lui");
        System.out.println(joiner.toString()); //output John, Danny, Lui


        String numbers = String.join("-", "1", "0", "1", "0");
        System.out.println(numbers); //output 1-0-1-0


        List<String> databases = Arrays.asList("OracleDB", "Mongo", "PostgreSQL", "MySQL");
        String string = String.join(", ", databases);
        System.out.println(string); //output OracleDB, Mongo, PostgreSQL, MySQL


        List<String> list = Arrays.asList("Angular", "Bootstrap", "NodeJS", "Django");
        String collect = list.stream()
                .collect(Collectors.joining("; ", "{", "}"));    // можно и просто joining("; ")
        System.out.println(collect); //output {Angular; Bootstrap; NodeJS; Django}



    }
}
