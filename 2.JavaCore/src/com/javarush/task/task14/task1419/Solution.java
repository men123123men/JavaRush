package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions)
            System.out.println(exception);
    }
    private static void initExceptions() {
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
            exceptions.add(new Lust("похоть"));
            exceptions.add(new Gluttony("чревоугодие"));
            exceptions.add(new Greed("жадность"));
            exceptions.add(new Sloth("лень"));
            exceptions.add(new Wrath("гнев"));
            exceptions.add(new Envy("зависть"));
            exceptions.add(new Pride("гордыня"));
            exceptions.add(new Acedia("уныние"));
            exceptions.add(new Vainglory("тщеславие"));
        }
    }
    static class DeadlySinException extends Exception{
        public DeadlySinException(String message) { super(message); }

        @Override
        public String toString() { return this.getClass().getSimpleName()+": "+this.getMessage(); }
    }
    static class Lust extends DeadlySinException{
        public Lust(String clarification) { super(clarification); }
    }
    static class Gluttony extends DeadlySinException{
        public Gluttony(String clarification) { super(clarification); }
    }
    static class Greed extends DeadlySinException{
        public Greed(String clarification) { super(clarification); }
    }
    static class Sloth extends DeadlySinException{
        public Sloth(String clarification) { super(clarification); }
    }
    static class Wrath extends DeadlySinException{
        public Wrath(String clarification) { super(clarification); }
    }
    static class Envy extends DeadlySinException{
        public Envy(String clarification) { super(clarification); }
    }
    static class Pride extends DeadlySinException{
        public Pride(String clarification) { super(clarification); }
    }
    static class Acedia extends DeadlySinException{
        public Acedia(String clarification) { super(clarification); }
    }
    static class Vainglory extends DeadlySinException{
        public Vainglory(String clarification) { super(clarification); }
    }
}
