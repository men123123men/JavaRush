package com.javarush.task.task08.task0819;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        ArrayList<Cat> list = new ArrayList<>();
        cats.remove(1);
        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }
    public static Set<Cat> createCats() {
        HashSet<Cat> set = new HashSet<>();
        for (int i = 0; i < 3; i++){
            set.add(new Cat());
        }
        return set;
    }
    public static void printCats(Set<Cat> cats) {
        for (Cat c : cats){
            System.out.println(c);
        }
    }
    public static class Cat{
    }
}
