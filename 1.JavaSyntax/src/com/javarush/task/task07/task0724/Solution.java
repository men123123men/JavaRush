package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human human1 = new Human("alex1",false,25);
        Human human2 = new Human("alex2",true,125);
        Human human3 = new Human("alex3",false,215);
        Human human4 = new Human("alex4",true,250);

        Human human5 = new Human("alexo1",false,25,human1,human2);
        Human human6 = new Human("alexo2",true,125,human1,human2);
        Human human7 = new Human("alexo3",false,225,human1,human2);
        Human human8 = new Human("alexo4",true,215,human1,human2);
        Human human9 = new Human("alexo5",false,250,human1,human2);

        Human[] family = {human1, human2, human3, human4, human5, human6, human7, human8, human9};
        for(Human member: family)
            System.out.println(member);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this(name, sex, age);
            this.father = father;
            this.mother = mother;

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















