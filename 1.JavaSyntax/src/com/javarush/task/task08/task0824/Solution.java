package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)  {
        ArrayList<Human> family = new ArrayList<>();
        for (int i = 0; i < 9; i++) {                                           // создал  все семейство
            family.add(new Human());
            family.get(i).age=i*3;
            family.get(i).name="name"+i;
            if (i%2==0) family.get(i).sex=true;
            else family.get(i).sex=false;
            family.get(i).children =  new ArrayList<>();
        }
        for (int i = 6; i < 9 ; i++) {                                          // установил родственные связи
            family.get(5).children.add(family.get(i));
            family.get(4).children.add(family.get(i));                  // Маме и папе добавляем детей
        }

        family.get(0).children.add(family.get(4));                    // дедушкам и бабушкам маму и папу
        family.get(1).children.add(family.get(4));
        family.get(2).children.add(family.get(5));
        family.get(3).children.add(family.get(5));

        for (Human h: family ) {
            System.out.println(h.toString());
        }
    }

    public static class Human {
        String name;
        int age;
        boolean sex;
        ArrayList<Human> children;


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
