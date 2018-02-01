package com.javarush.task.experements.innerClasses.philosophyOfJava;

public class DotThis {
    void f() { System.out.println("DotThis.f()"); }
    public class Inner {
        String string;
        public DotThis outer() {
            return DotThis.this;
            // A plain "this" would be Inner's "this"
            // получение ссылки на объект внешнего класса
        }
    }
    public Inner inner() { return new Inner(); }

    public static void main(String[] args) {
        DotThis dt = new DotThis();

        //DotThis.Inner dti = dt.inner();
        //DotThis.Inner dti = dt.new Inner();
        DotThis.Inner dti = new DotThis().new Inner();

        dti.outer().f();
        System.out.println("End");
    }
}
