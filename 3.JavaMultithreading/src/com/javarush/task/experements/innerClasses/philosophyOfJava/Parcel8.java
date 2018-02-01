package com.javarush.task.experements.innerClasses.philosophyOfJava;



class Wrapping {
    private int i;
    public Wrapping(int x) { i = x; }
    public int value() { return i; }
}


public class Parcel8 {

    public class MyWrapping extends  Wrapping{

        public MyWrapping(int x) {
            super(x);
        }
        @Override
        public int value() {
            return super.value()*super.value();
        }
    }


    public Wrapping wrapping(int x) {        // Вызов конструктора базового класса:

        return new Wrapping(x) {             // аргумент конструктора.

            @Override
            public int value() {
                return super.value();
            }
        };
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(3);
        Wrapping w2 = p.new MyWrapping(10);


        System.out.println(w.value()+"\n"+w2.value());
    }
}
