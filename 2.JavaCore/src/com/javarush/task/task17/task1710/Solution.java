package com.javarush.task.task17.task1710;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
//-c name sex bd
//-u id name sex bd
//-d id
//-i id

    public static void main(String[] args) {
        //start here - начни тут
        switch(args[0]){
            case "-c" : allPeople.add(createPerson(args[1], args[2], args[3])); break;
            case "-u" : allPeople.set(Integer.parseInt(args[1]), createPerson(args[2], args[3], args[4])); break;
            case "-d" : allPeople.remove(Integer.parseInt(args[1])) ; break;
            case "-i" : System.out.println(allPeople.get(Integer.parseInt(args[1])));
        }
    }
    public static Person createPerson(String name, String sex, String bd){
        switch (sex){
            case "м": return Person.createMale( name, new Date(bd)) ;
            case "ж": return Person.createFemale( name, new Date(bd)) ;
            default: return null;
        }
    }
}
