package com.javarush.task.experements.innerClasses.philosophyOfJava;

public interface ClassInInterface {
    int value = 0b100010;
    void howdy();

    //public static  // классы внутри интерфейсов являются вложенными публичными по-умолчанию
     class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }
        public static void main(String[] args) {
            Test t = new Test();
            t.howdy();
            System.out.println("Some TEXT!");
        }
    }

}



