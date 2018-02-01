package com.javarush.task.experements.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class t7CollectGrouping {
    public static void main(String... args){
        List<Human> humans = List.of(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3)
        );
        Map<String,List<Human>> map = new HashMap<>();

        for(Human h:humans){
            if(!map.containsKey(h.getSurname()))
                map.put(h.getSurname(), new ArrayList<Human>());
            map.get(h.getSurname()).add(h);
        }




        Map<String,List<Human>> map2 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname));


        Map<String, Long> map3 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.counting()));


        Map<String, Integer> map4 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.summingInt(Human::getFriendsAmount)));

        Map<String,Set<String>> map5 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname,Collectors.mapping(Human::getName,Collectors.toSet())));


        map2.forEach((k,v)-> {System.out.printf("%11s => ",k);
        v.forEach(vv-> System.out.println((v.indexOf(vv)==0?" ":"\t\t\t\t")+vv.getName()+" "+vv.getSurname()));});








    }
    static class Human{
        private  String name,surname;
        private int friendsAmount;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getFriendsAmount() {
            return friendsAmount;
        }

        public void setFriendsAmount(int friendsAmount) {
            this.friendsAmount = friendsAmount;
        }

        public Human(String name, String surname, int friendsAmount) {

            this.name = name;
            this.surname = surname;
            this.friendsAmount = friendsAmount;
        }
    }
}

