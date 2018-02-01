package com.javarush.task.experements.innerClasses.philosophyOfJava;

//: innerclasses/MultiNestingAccess.java
// Вложенные классы могут обращаться ко всем членам всех
// классов, в которых они находятся.
class MNA {
    private void f() {}
    class A {
        private void g() {}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

//class D{}
//class E{}
//class F{}
//class J{}
//class H{}
//class ABC{
//    D ddd = new D(){
//        E eee = new E(){
//            F fff = new F(){
//                J jjj = new J(){
//                    H hhh = new H(){
//                        public void print(){
//                            System.out.println("ТАкие дела!");
//                        }
//                    };
//                };
//            };
//        };
//    };
//}





public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
        System.out.println("And now...");
        mnaab = null;
        mnaab = new MNA().new A().new B();

//        ABC abc = new ABC();
//        System.out.println("End");
    }
}
