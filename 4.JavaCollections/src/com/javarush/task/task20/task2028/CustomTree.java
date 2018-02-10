package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    @Override
    public String get(int index){
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    Entry<String> root;

    public static void main(String[] args) {
//        List<String> list = new CustomTree();
//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }

        List<String> list = IntStream.range(1, 16)
                .mapToObj(Integer::toString)
                .collect(Collectors.toCollection(CustomTree::new));

        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }
    static class Entry<T> implements Serializable{
        String  elementName;
        int lineNumber;

        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = availableToAddRightChildren = true;

        }
        public void checkChildren(){
            if (Objects.nonNull(leftChild))
                availableToAddLeftChildren = false;
            if (Objects.nonNull(rightChild))
                availableToAddRightChildren = false;
        }
        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren||availableToAddRightChildren;
        }
    }

    private String getParent(String s) {
        return "123123";
    }

    @Override
    public int size() {
        return 0;
    }
}
