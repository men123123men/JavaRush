package com.javarush.task.experements.innerClasses.philosophyOfJava;

//: innerclasses/Factories.java


interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}


//class FirstService extends Service {
//    @Override
//    public void method1() { }
//
//    @Override
//    public void method2() { }
//
//    ServiceFactory factory = FirstService::new;
//}
//
//class SecondService extends  Service{
//    @Override
//    void method1() { }
//
//    @Override
//    void method2() { }
//
//    public static ServiceFactory factory= new ServiceFactory(){
//            @Override
//            public Service getService() {
//                return new SecondService();
//            }
//        };
//}



class Implementation1 implements Service {
    private Implementation1() {}
    @Override
    public void method1() {System.out.println("Implementation1 method1");}
    @Override
    public void method2() {System.out.println("Implementation1 method2");}
    public static ServiceFactory factory =

            Implementation1::new

            ;
}

class Implementation2 implements Service {
    private Implementation2() {}
    @Override
    public void method1() {System.out.println("Implementation2 method1");}
    @Override
    public void method2() {System.out.println("Implementation2 method2");}
    public static ServiceFactory factory =

            new ServiceFactory() {
                @Override
                public Service getService() {
                    return new Implementation2();
                }
            }

            ;
}

public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        // Реализации полностью взаимозаменяемы;
        serviceConsumer(Implementation2.factory);
    }
}