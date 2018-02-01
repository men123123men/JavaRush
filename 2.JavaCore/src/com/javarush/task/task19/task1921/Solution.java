package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader fileReader = new BufferedReader(new FileReader("/Users/admin/Desktop/Persons.txt"));

        //Pattern p = Pattern.compile("([\\w -]+)\\s(\\d{1,2} \\d{1,2} \\d{2,4})", Pattern.UNICODE_CHARACTER_CLASS);
        //Pattern p = Pattern.compile("([А-Яа-я -]+)\\s(\\d{1,2} \\d{1,2} \\d{2,4})");
    Pattern p = Pattern.compile("(?U)(?<Name>[\\w -]+) (?<BDay>\\d{1,2} \\d{1,2} \\d{2,4})");


    Matcher m = p.matcher("");
    System.out.println("\tКолличество групп = "+m.groupCount());
    String line;
    while ((fileReader.ready())){
        m.reset(line=fileReader.readLine());
        System.out.println(line);
        if (m.find())
            PEOPLE.add(new Person(m.group("Name"), new SimpleDateFormat("dd MM yyyy").parse(m.group("BDay"))));
    }

        Integer i = 23;

        try {
            System.out.println("\n\t\t\t"+Class.forName("Person").getClassLoader()+"\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("===================================");
        PEOPLE.forEach(System.out::println);
        fileReader.close();

    }
}
