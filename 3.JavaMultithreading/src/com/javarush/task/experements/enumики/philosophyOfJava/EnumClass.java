package com.javarush.task.experements.enumики.philosophyOfJava;
//enum Shrubbery { GROUND, CRAWLING, HANGING }
import static com.javarush.task.experements.enumики.philosophyOfJava.Shrubbery.*;

public class EnumClass {
    public static void main(String[] args) {
        System.out.println(args[0]);
        Shrubbery.valueOf("CRAWLING");
        Enum.valueOf(Shrubbery.class,"CRAWLING");
        System.out.println(CRAWLING.getClass());
        System.out.println(CRAWLING.getDeclaringClass());
        System.out.println(CRAWLING.getClass().getSuperclass());
        System.out.println(CRAWLING.getClass().getSuperclass().getSimpleName());
        System.out.println(CRAWLING.getDeclaringClass().getName().replaceAll("(?U)\\w+\\.",""));

        for(Shrubbery s : Shrubbery.values()) {
            System.out.println("\n"+s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(CRAWLING) + " ");
            System.out.println(s.equals(CRAWLING) + " ");
            System.out.println(s == CRAWLING);
            System.out.println(s.name());
        }
        // Produce an enum value from a string name:
        for(String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
