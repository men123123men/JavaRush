package com.javarush.task.experements.innerClasses.philosophyOfJava;

class WithInner {
    int outerInt=0;
    class Inner {

        int innerInt=111111;
        Inner(){
            super();
        }
    }
}

public class InheritInner extends WithInner.Inner {
//     InheritInner() {} // He компилируется
    InheritInner(WithInner wi) {
        wi.super();
    }
    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);

        WithInner.Inner qwer = new WithInner().new Inner();
        WithInner asdf = new WithInner();

    }
}