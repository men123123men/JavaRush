package com.javarush.task.task19.task1921;

import java.util.Date;

public class Person {
    private String name;
    private Date birthday;
    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public String getName() {
        return name;
    }
    public Date getBirthday() {
        return birthday;
    }
    @Override
    public String toString() {
        return String.format("Имя: \"%s\"\nдень: \"%2$td\"\nмесяц: \"%2$tB\"\nгод: \"%2$tY\"\n",name,birthday);
    }
}
