package com.javarush.task.experements.innerClasses.philosophyOfJava;

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) { items = new Object[size]; }

    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
// Внутренний класс может обращаться ко всем полям и методам внешнего класса-оболочки, как будто они описаны в нем самом.
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() { return i == items.length; }
        @Override
        public Object current() { return items[i]; }
        @Override
        public void next() { if(i < items.length) i++; }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Sequence sequence = new Sequence(20);

        int countOfItems = ((Object[]) sequence.getClass().getDeclaredField("items").get(sequence)).length;
        System.out.println(countOfItems);

        for(int i = 0; i < countOfItems; i++)
            sequence.add(i+1);

        Selector selector = sequence.selector();

        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

    }
}
