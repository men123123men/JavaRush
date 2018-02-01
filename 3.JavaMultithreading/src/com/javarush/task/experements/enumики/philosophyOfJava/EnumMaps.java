package com.javarush.task.experements.enumики.philosophyOfJava;

import java.util.EnumMap;
import java.util.function.BiConsumer;

@FunctionalInterface
interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args){
        Command command1 = ()-> System.out.println("Kitchen fire!");
        Command command2 = ()-> System.out.println("Bathroom alert!");
        Command command3 = ()-> System.out.println("Office working!");

        EnumMap<AlarmPoints, Command> enumMap = new EnumMap<>(AlarmPoints.class);
        enumMap.put(AlarmPoints.KITCHEN,command1);
        enumMap.put(AlarmPoints.BATHROOM,command2);
        enumMap.put(AlarmPoints.OFFICE1, command3);


        BiConsumer<AlarmPoints,Command> biConsumer = (point, command)-> {
            System.out.printf("%10s: ",point);
            command.action();
        };

        //enumMap.forEach((k,v)->System.out.println(k));
        enumMap.forEach(biConsumer);


    }
}
