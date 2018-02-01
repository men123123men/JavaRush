package com.javarush.task.experements.innerClasses.philosophyOfJava;



//: innerclasses/Contents.java
interface Contents {
    int value();
}
interface Destination {
    String readLabel();
}

class Parcel4 {

    private class PContents implements Contents {
        private int i = 11;
        @Override
        public int value() { return i; }
    }

    protected class PDestination implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        @Override
        public String readLabel() { return label; }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }
    public Contents contents() {
        return new PContents();
    }
}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        //Parcel4.PDestination d =(Parcel4.PDestination) p.destination("efe");

        // Запрещено - нет доступа к private-классу:
        // Более того, нельзя даже выполнить нисходящее преобразование к закрытому (private) внутреннему классу (или protected, кроме наследников), поскольку его имя недоступно

        //Parcel4.PContents pc = p.contents();

        //  обращение к конструктору не канает
//        Contents pdc = p.new PContents();
//        Destination pd = p.new PDestination("sd");

    }
}
