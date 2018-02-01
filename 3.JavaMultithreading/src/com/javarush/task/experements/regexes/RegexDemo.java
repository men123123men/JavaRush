package com.javarush.task.experements.regexes;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) throws FileNotFoundException {
        String regex = "(?m)^abc$";
        String inport = "abc\nabc";
        System.out.println("regex = " + regex);
        System.out.println("input = " + inport);
        Pattern p = Pattern.compile(regex,Pattern.COMMENTS);
        Matcher m = p.matcher(inport);
        while (m.find())
            System.out.println("Found [" + m.group() + "] starting at "
                    + m.start() + " and ending at " + (m.end() - 1));
        System.out.println(p.pattern());
        System.out.println(p.flags());
        System.out.println(Pattern.matches("[a-z ]{41}", "all lowercase letters and whitespace only"));


        String str = "1234567890olololololoatatatazatatatzaza";
        str = str.replaceAll("(?<a1>..)(?<b2>...)", "$1 $2 ");
        System.out.println(str);









    }
}
