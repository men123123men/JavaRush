package com.javarush.task.experements.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class t8FlatMap {
    static class Human {
        private  String name;
        private  List<String> pets;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getPets() {
            return pets;
        }

        public void setPets(List<String> pets) {
            this.pets = pets;
        }

        public Human(String name, List<String> pets) {

            this.name = name;
            this.pets = pets;
        }
    }
    public static void main(String[] args) throws IOException {
        List<Human> humans = List.of(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        List<String> pets = new ArrayList<>();
        humans.forEach(h->pets.addAll(h.getPets()));

        List<String> pets2 = humans.stream()
                .map(human->human.getPets())  //преобразовываем Stream<Human> в Stream<List<Pet>
                .flatMap(list->list.stream()) //"разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .collect(Collectors.toCollection(()->new ArrayList<String>()));

        List<String> pets3 = humans.stream()
                .flatMap(human -> human.getPets().stream())
                .collect(Collectors.toList());



        System.out.println(pets);
        //pets.forEach(System.out::println);


        int[][][] arr = {{{1,2},{3,4},{5,6}},{{7,8},{9,10},{11,12}},{{13,14},{15,16},{17,18}}};

        int[] newArr = Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println(Arrays.toString(newArr));


        BufferedReader br = new BufferedReader(new FileReader(""));

        br.lines().filter(line->line.startsWith("sf"+" ")).forEach(System.out::println);


        List<String> lines = new ArrayList<>();
        Path path = Paths.get("file.txt");

        Stream<String> lineStream = Files.lines(path);

            lines = lineStream.collect(Collectors.toList());



        System.out.println(lines);









    }
}
