package com.javarush.task.experements.RTTI.philosophyOfJava;

interface Null{}

public class Person {
    public static class NullPerson extends Person implements Null{
        public NullPerson() {
            super("None", "None", "None");
        }
        @Override
        public String toString(){
            return getClass().getSimpleName();
        }
    }

    public final String first, last, address;
    public static final Person NULL = new NullPerson();

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void test1(int[] ints){
        for(int i:ints)
            System.out.print(i+" ");
        System.out.println();
        //Stream.of(ints).forEach(System.out::println);
    }
    public static void test2(int... ints){
        int ii = ints[3];
        System.out.println(ii);
        for(int i:ints)
            System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String[] args){
        int[] values = {5,6,3,4,7,8,3,10};

        test1(values);
        //test1(null);    // NullPointerException (в рантайме)
        test1(new int[0]);
        test1(new int[18]);
        test1(new int[]{4,6,2,6,21,'e','a'});
        //test1();          //не компилится
        //test1(1,2,3,4);   //не компилится

        System.out.println("--------");

        test2(values);
        //test2(null);    // NullPointerException (в рантайме)
        test2(new int[0]);
        test2(new int[18]);
        test2(new int[]{4,6,2,6,21,'e','a'});
        test2();
        test2(1,2,3,4);


    }
}
