package com.javarush.task.experements.lambdas;

public class t22Default_Static_Methods {
    public static void main(String[] args){
        Human human = new Human() {};
        human.walk();

        Runner runner = new Runner();
        runner.walk();




    }

    interface Human{
        default void walk(){
            System.out.println("Human.walk()");
        }
        static void staticWalk(){
            System.out.println("Human.staticWalk()");
        }
    }
    interface Walkable{
        default void walk(){
            System.out.println("Walkable.walk()");
        }
        static void staticWalk(){
            System.out.println("Human.staticWalk()");
        }
    }

}
class Runner implements t22Default_Static_Methods.Human{
    @Override
    public void walk() {
        System.out.println("Runner.walk()");
    }
}

class TwoInterfaceInmlemented implements t22Default_Static_Methods.Human, t22Default_Static_Methods.Walkable {
    // из-за ромбовидной проблеммы мы вынужденны реализовывать свою версию default метода тут
    @Override
    public void walk() {
        System.out.println("I was forced to realise my own walk method");
    }
    // staticWalk() не переопределяется и не наследуется(т.е. у этого класса тупо нет этого метода)
    // поэтому нет ромбовидной проблеммы в этом классе

}