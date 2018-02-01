package com.javarush.task.experements.lambdas;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class t17Joining_StringJoiner {
    public static void main(String[] args){
        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.add("Jone");
        stringJoiner.add("Dendy");
        stringJoiner.add("Lui");
        System.out.println(stringJoiner);


        StringJoiner longStringJoin = new StringJoiner("\t");
        longStringJoin.add("First").add("Sesond").add("Thierd");
        System.out.println(longStringJoin);


        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        joiner.add("Jone").add("Denny").add("Vasia");
        System.out.println(joiner);


        String numbers = String.join("-","1","2","3","4");
        System.out.println(numbers); //output 1-0-1-0


        List<String> databases = List.of("OracleDB", "Mongo",
                "PostgreSQL", "MySQL");
        String DBes = String.join(" && ",databases);
        System.out.println(DBes);


        String fraimeWorkes = Stream.of("Spring", "Hibernate", "JPA", "JSF")
                .collect(Collectors.joining(" & ","Это всё (",") фреймуорки"));
        System.out.println(fraimeWorkes);


    }
}

