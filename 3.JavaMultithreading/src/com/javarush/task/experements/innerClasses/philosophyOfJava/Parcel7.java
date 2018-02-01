package com.javarush.task.experements.innerClasses.philosophyOfJava;

public class Parcel7 {

    class MyContents implements Contents {
        private int i = 11;
        @Override
        public int value() { return i; }
    }
    public Contents contents0() { return new MyContents(); }


    public Contents contents1() {
        return new Contents() {// Вставить определение класса
            private int i = 11;
            @Override
            public int value() { return i; }
        };  // В данной ситуации точка с запятой необходима
    }

    public Contents contents2() {
        return new Contents() {
            private int i = 11;
            @Override
            public int value() { return i; }
        };
    }

    public static void main(String[] args) {

        Parcel7 p = new Parcel7();

        Contents c = p.contents0();    // создание экземпляра внутренного класса

        Contents cс = p.contents1();   // создание экземпляра анонимного класса

        Contents cсс = p.contents2();  // создание экземпляра анонимного класса


    }
}
