package com.javarush.task.experements;

public class Varargs {
    public static void test1(int[] ints){
        for(int i:ints)
            System.out.print(i+" ");
        System.out.println();
        //Stream.of(ints).forEach(System.out::println);
    }
    // меджу точками нельзя ставить пробелы
    public static void test2(int... ints){ // тут посути создается массив
        // а если нихрена не передали, то массив нулевой длины
//        int ii = ints[0];
//        System.out.println(ii);
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
        test2(new int[0]); // равносильно test2()! а с той стороны мы и выташим int[0]
        test2(new int[18]);
        test2(new int[]{4,6,2,6,21,'e','a'});
        test2();
        //test2(1,2,3,4, Integer.parseInt("ss")); // // NullPointerException (в рантайме)

        //Objects.equals()
    }
}
