package com.javarush.task.experements.enumики;

import java.io.Closeable;
import java.io.IOException;

// Здесь показано все, что мы можем сделать с Enum
public enum ThreadStatesEnum implements Closeable {
    START(1){
        @Override
        public String toString(){
            return "Реализация START. Приоритет : " + getPriority();
        }
        @Override
        public String getDetail() { return "START"; }
    },
    RUNNING(2){
        @Override
        public String getDetail() { return "RUNNING"; }
    },
    WAITING(3){
        @Override
        public String getDetail() { return "WAITING"; }
    },
    DEAD(14){
        @Override
        public String getDetail() { return "DEAD"; }

    };

    private ThreadStatesEnum(int i){ priority = i; }        //Enum конструкторы должны всегда быть private.

    private int priority;
    public int getPriority(){ return this.priority; }       //У Enum могут быть методы
    public void setPriority(int p){ this.priority = p; }

    public abstract String getDetail();

    @Override
    public String toString(){                               //Enum может переопределять методы
        return "Стандартная реализация ThreadStatesConstructors. Приоритет : " + getPriority();
    }
    @Override
    public void close() throws IOException {
        System.out.println("Закрытие Enum");
    }


}