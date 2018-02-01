package com.javarush.task.experements.lambdas;


import java.util.Arrays;

public class t11SortsdParallelSequential {
    public static void main(String [] args){
        String[] strings =
                "aaaavdgrthyj".chars()
                .mapToObj(i->String.valueOf((char)i))
                .toArray(String[]::new);

        System.out.println("неповторяющиеся");
        Arrays.stream(strings)
                .distinct()
                .forEach(System.out::println);
        // отличающиеся{т.е. уникальные, !equqls()}
        // если метод equqls() для значений стрима не определен,
        // то distinct() тупо ничего не делает(ошибки тоже не кинет)

        System.out.println("сортированные");
        Arrays.stream(strings)
                .sorted()  // если элементы реализуют интерфайс Comparable
                .forEach(System.out::println);

        System.out.println("сортированные с компаратором");
        Arrays.stream(strings)
                .sorted(String::compareToIgnoreCase) // если не реализуют
                // то нужно где-то изыскать подходящий метод
                .forEach(System.out::println);

        System.out.println("парралельные");
        Arrays.stream(strings)
                .parallel()     // вывод в произвольном порядке
                .forEach(System.out::println);

        System.out.println("последовательные");
        Arrays.stream(strings)
                .parallel()    // делает параллельным
                .sequential()  // делает последовательным
                .forEach(System.out::println);









    }
}
