package com.javarush.task.experements.enumики.philosophyOfJava;

import java.util.Arrays;
import java.util.Random;

interface Food {
    enum Appetizer implements Food{
        SALAD, SOUP, SPRING_ROLLS
    }
    enum MaineCourse implements Food{
        LASAGNE, BURRITO, PAD_THAI, LENTILS,HUMMOUS, VINDALOO,
    }
    enum Desserts implements Food{
        TIRAMISU, GALATO, FRUIT
    }
    enum Coffee implements Food {
         DECAF_COFFEE,LATTE, CAPPUCCINO, TEA,
    }
}
public class TypeOfFood {
    public static void main(String[] args) {
        Food food[] = {Food.Appetizer.SALAD, Food.MaineCourse.PAD_THAI, Food.Coffee.TEA};
        Course course;
        Arrays.stream(Course.values())
                .map(Course::randomSelection)
                .forEach(System.out::println);
    }
}
enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINECOURSE(Food.MaineCourse.class),
    DESSERTS(Food.Desserts.class),
    COFFEE(Food.Coffee.class);

    Food[] allFoods;
    static Random random = new Random(47);
    Course(Class<? extends Food> kind){
        allFoods = kind.getEnumConstants();
    }
    public Food randomSelection(){


        int rand = (int) (Math.random() * allFoods.length);
        int rand2= random.nextInt(allFoods.length);
        return allFoods[rand2];
    }
}
