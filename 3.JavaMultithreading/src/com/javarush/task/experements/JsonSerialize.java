package com.javarush.task.experements;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class JsonSerialize {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PersonSer person = new PersonSer("Vasa", "Pupkin",45,true);

        // чтоб отступы были
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //String vasaPupkin = objectMapper.writeValueAsString(person);
        //System.out.println(vasaPupkin);



        // создание временного файла
        File file = File.createTempFile("vasaPupkin.json",null);

        // запись в файл
        objectMapper.writeValue(file,person);

        // путь к файлу
        System.out.println(file.getPath());
        // считываем содержимое файла
        Files.lines(file.toPath()).forEach(System.out::println);

        // считываем из jsonФайла (у класса считываемого объекта должен быть дефолтный конструктор)
        PersonSer personRead = objectMapper.readValue(file,PersonSer.class);
        System.out.println(personRead);

        List<PersonSer> personSerList = new ArrayList<>();





        /*
        /Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home/bin/java
        "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=53767:/Applications/IntelliJ IDEA CE.app/Contents/bin"
         -Dfile.encoding=UTF-8
         -classpath "/Users/admin/Downloads/20September/JavaRushTasks/out/production/3.JavaMultithreading
         :/Applications/IntelliJ IDEA CE.app/Contents/redist/annotations-java8.jar
         :/Users/admin/Downloads/jackson-annotations-2.9.3.jar
         :/Users/admin/Downloads/jackson-core-2.9.3.jar
         :/Users/admin/Downloads/jackson-databind-2.9.3.jar"
         com.javarush.task.experements.JsonSerialize

        */


    }
}

class PersonSer{

    String name,sername;
    int age;
    boolean sex;

    public PersonSer() {
    }

    public PersonSer(String name, String sername, int age, boolean sex) {
        this.name = name;
        this.sername = sername;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

