package com.javarush.task.experements;

public class AboutStatics {

    {
        System.out.println(1);
    }

    static {
        System.out.println(2);
    }

    public AboutStatics() {
        System.out.println(3);
    }

    public void myMethod(){
        System.out.println(4);
    }

    public static void main(String[] args) {
        System.out.println(5);
        AboutStatics o = new AboutStatics();
        o.myMethod();
        InnerClass inner = new InnerClass();
        inner.myMethod();
        Integer int1 = new Integer(23);
        Integer int2 = new Integer(23);

        Integer int3 = 45;
        Integer int4 = 45;

        System.out.println(int1==int2);
        System.out.println(int3==int4);

    }

    static class InnerClass{

        {
            System.out.println(10);
        }
        static {
            System.out.println(20);
        }

        public InnerClass() {
            System.out.println(30);
        }


        public void myMethod(){
            System.out.println(40);
        }
    }
}