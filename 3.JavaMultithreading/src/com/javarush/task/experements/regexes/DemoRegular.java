package com.javarush.task.experements.regexes;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegular {
    public static void main(String[] args) {

        System.out.println(Pattern.compile("a+y").matcher("aaay").matches());

        Matcher m2 = Pattern.compile("(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*").matcher("адреса эл.почты:mymail@tut.by и rom@bsu.by");
        while (m2.find())
            System.out.println("e-mail: " + m2.group());

        Arrays.stream(Pattern.compile("\\d+\\s?").split("java5tiger 77 java6mustang")).forEach((s)->System.out.printf("\"%s\"\n",s));

        Pattern pattern = Pattern.compile("[:;]");  // ":|;"
        String[] animals = pattern.split("cat:dog;bird:cow");
        Arrays.asList(animals)
                .forEach(animal -> System.out.print(animal + " "));
        System.out.println();
        Arrays.stream(animals)
                .map(x->x+" ")
                .forEach(System.out::print);
    }
}
