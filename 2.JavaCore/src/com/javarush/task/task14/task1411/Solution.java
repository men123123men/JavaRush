package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] keys = {"user", "loser", "coder", "proger"};

        List<Person> persons = new ArrayList<>();

        String key = null;

        //while (Arrays.asList(keys).contains(key = reader.readLine())) { // ГЕНИАЛЬНО!!!!
        while (true){

            if (!Arrays.asList(keys).contains(key = reader.readLine())) break;

            switch (key) {
                case "user":
                    persons.add(new Person.User()); break;
                case "loser":
                    persons.add(new Person.Loser()); break;
                case "coder":
                    persons.add(new Person.Coder()); break;
                case "proger":
                    persons.add(new Person.Proger()); break;
            }
        }
        for(Person currentPerson: persons)
            doWork(currentPerson);
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
