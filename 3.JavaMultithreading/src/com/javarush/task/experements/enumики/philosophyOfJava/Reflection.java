package com.javarush.task.experements.enumики.philosophyOfJava;


import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Explore{ HERE, THERE}
public class Reflection {

    public static Set<String> analyze(Class clazz){

        Arrays.stream(clazz.getGenericInterfaces())
                .forEach(System.out::println);

        System.out.printf("Class: %s%nBase:  %s%nMethods: %n"
                ,clazz.getSimpleName(),clazz.getSuperclass().getSimpleName());

        return Stream.of(clazz.getMethods())
                .map(Method::toString)
                .map(s->s.replaceAll("(?U)\\w+\\.", ""))
                .peek(System.out::println)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args){
        Explore eer = Explore.HERE;
        Set<String> exploreMethods = analyze(Explore.class);
        System.out.println();
        Set<String> enumMethods = analyze(Explore.class.getSuperclass());

        System.out.printf("Explore.containsAll(Enum): %s%n", exploreMethods.containsAll(enumMethods));
        System.out.printf("Explore.removeAll(Enum): %s%n", exploreMethods.removeAll(enumMethods));

        exploreMethods.forEach(System.out::println);


        // декомпелировать этот класс в терминале :
        // javap /Users/admin/Downloads/20September/JavaRushTasks/out/production/3.JavaMultithreading/com/javarush/task/experements/enumики/philosophyOfJava/Explore.class

    }
}

//    public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable {...}

//    final class Explore extends Enum<Explore> {
//        public static final Explore HERE;
//        public static final Explore THERE;
//        public static Explore[] values();            // при расширении добавляются эти 2 метода
//        public static Explore valueOf(String arg0);  // это с похожей сигнатурой
//        static {};
//    }
