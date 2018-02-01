package com.javarush.task.experements.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class t6Collect {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> piDigits = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 9);


        List<Integer> oddNumders1 = numbers.stream()
                .filter(i->i%2!=0)
                .collect(Collectors.toList());

        //System.getProperties().entrySet().forEach(System.out::println);


        List<String> phones = List.of("iPhone 6 S", "Lumia 950",
                "Huawei Nexus 6P", "Samsung Galaxy S 6",
                "LG G 4", "Xiaomi MI 5", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 5",
                "Lenovo S 850");

        ArrayList shortNamedPhones = phones.stream()
                .filter(ph->ph.length()<10)
                .peek(System.out::println)
                //.collect(Collectors.toList());
                //.collect(Collectors.toCollection(ArrayList::new));
                //.collect(ArrayList::new,List::add,List::addAll);
                .collect(
                        ()->new ArrayList(),  // Suplaer  ArrayList get();
                        (list,item)->list.add(item),  // BiConsumer
                        (list,list2)->list.addAll(list2)
                );


        System.out.println(shortNamedPhones.getClass().getSimpleName());


        List<String> names = List.of("Jaime", "Daenerys", "", "Tyrion", "");
        List<String> nnames2 = Arrays.asList("Jaime", "Daenerys",
                "", "Tyrion", "");

        Queue<String> queue =   names.stream()
                .filter(n->!n.isEmpty())
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(queue);




    }

}
