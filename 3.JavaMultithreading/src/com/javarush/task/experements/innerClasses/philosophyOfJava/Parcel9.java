package com.javarush.task.experements.innerClasses.philosophyOfJava;

public class Parcel9 {
    // Для использования в безымянном внутреннем классе
    // аргументы должны быть неизменны (final)
    public Destination destination(String dest) {

        return new Destination() {
            private String label = dest;  // должна быть эфектив файнал(а то получим ошиблу во время компиляции)
            @Override
            public String readLabel() { return label; }
        };

    }
    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
