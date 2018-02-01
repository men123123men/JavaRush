package com.javarush.task.experements.forComparing;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    @Override
    public int compareTo(Employee o) {
        //return id-o.id; //  не стоит так делать из-за возможности выхода результата за пределы Integer.MAX_VALUE
        //return id<o.id? -1 : id==o.id? 0 : 1; // для int'а так можно, но зачем мучать киску?
        //return salary<o.salary? -1: salary==o.salary?  0 : 1;  // не корректно обрабатывает c NaN



        //return Integer.compare(id,o.id); // делать надо так
        //return Boolean.compare(sex,o.sex);
        //return Double.compare(salary,o.salary);
        int idCompare = Integer.compare(id,o.id);
        return idCompare!=0? idCompare : name.compareTo(o.name);
    }

    public static final Comparator<Employee> EMPLOYEE_COMPARATOR_1 = (e1,e2)->{
        int res = Integer.compare(e1.id,e2.id);

        return res==0? e1.name.compareTo(e2.name): res;
    };

    public static final Comparator<Employee> EMPLOYEE_COMPARATOR_2 =
//            Comparator.comparingInt((Employee e) -> e.id).thenComparing(e -> e.name);
//            Comparator.comparingInt(Employee::getId).thenComparing(Employee::getName);
            Comparator.comparingInt(Employee::getId)
                    .thenComparing(Employee::getName,String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(Employee::getSalary, Comparator.reverseOrder());






    private int id;
    private String name;
    private int age;
    private double salary;
    private boolean sex;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(int id, String name, int age, double salary, boolean sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.sex = sex;
    }

    @Override
    // переопределим метод toString() для печати
    // информации об объекте Employee в читабельном виде
    public String toString() {

        return "[id=" + this.id + ", name=" + this.name +
                ", age=" + this.age + ", salary=" + this.salary + "]";
    }
}