package com.javarush.task.experements.forComparing;

import java.util.*;
import java.util.stream.Collectors;

public class FirstClass {
    public static void main(String... args){

        int[] ints = new Random().ints(10,100,200).toArray();

//        for(int i:ints)
//            System.out.println(i);
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        String[] strings = {"R","w","c","A"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        List<String> listOfStrings = new ArrayList<>(List.of("T","K","b","W"));
        Collections.sort(listOfStrings);
        String  stringOfList = listOfStrings.stream().collect(Collectors.joining(" ", "[","]"));
        System.out.println(stringOfList);


        // создаем массив объектов Employee
        Employee[] empArr = new Employee[4];
// заполняем массив объектов Employee данными
        empArr[0] = new Employee(10, "Andrew", 21, 10000,true);
        empArr[1] = new Employee(20, "Dmitriy", 49, 20000,true);
        empArr[2] = new Employee(5, "Viktoria", 45, 5000,false);
        empArr[3] = new Employee(1, "Alexandra", 42, 50000,false);
// сортируем массив с использованием Comparable
        Arrays.sort(empArr);
        System.out.println("Стандартная сортировка для массива объектов Employee:");
        Arrays.asList(empArr).forEach(System.out::println);
    }

}
