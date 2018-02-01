package com.javarush.task.experements.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class t5Map {
    public static void main(String... args){
        List<Integer> numbers = Arrays.asList(1,23,4,45,5,null,3,2,43);
        Function<Integer,Integer> power20 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };
        t5Map my = new t5Map();
        Function<Integer,Integer> power21 = ToSquare::toSquare;
        Function<Integer,Integer> power22 = i->(int) Math.pow(i,2);
        Function<Integer,Integer> power23 = my::toSquareThear;
        Function<Integer,Integer> power24 = i->i*i;

        numbers.stream()
                .filter(Objects::nonNull)
                .map(power23)
                .forEach(System.out::println);



        List<String> strings =Arrays.asList("john", "arya", "sansa");
        strings.stream()
//                .map(StringUtils::capitalize)
                .forEach(System.out::println);

        String capitalizeTest = "abcdef";
        capitalizeTest = capitalizeTest.substring(0,1).toUpperCase()+capitalizeTest.substring(1);
        System.out.println(capitalizeTest);




        class Car {
            private String number;
            private int year;

            public Car(String number, int year) {
                this.number = number;
                this.year = year;
            }

            public String getNumber() {
                return number;
            }

            public int getYear() {
                return year;
            }
        }

        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));
        cars.stream()
                .filter(car->car.getYear()>2010)
                .map(Car::getNumber)
                .filter(Objects::nonNull)
                .filter(number->!number.isEmpty())
                .forEach(System.out::println);

























    }
    int toSquareThear(int i){return i*i; }


interface ToSquare{
    static int toSquare(int i){
        return i*i;
    }
}

}