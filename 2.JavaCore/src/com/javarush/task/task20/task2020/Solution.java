package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution{

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + "'\n" +
                    ", lastName='" + lastName + "'\n" +
                    ", fullName='" + fullName + "'\n" +
                    ", greetingString='" + greetingString + "'\n" +
                    ", country='" + country + "'\n" +
                    ", sex=" + sex + "'\n" +
                    ", outputStream=" + outputStream +
                    '}';
        }

        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = File.createTempFile("tempFile",null);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Person first = new Person("Ivan","Ivanov", "Russia", Sex.MALE);
        oos.writeObject(first);
        oos.close();

        Person second = (Person) ois.readObject();
        ois.close();
        System.out.println(second);

    }
}
