package com.javarush.task.task20.task2028;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Closeable, Serializable {
    public static void main(String[] args) {
//        List<String> list = new CustomTree();
//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }
        List<String> list = IntStream.rangeClosed(1, 16)
                .mapToObj(Integer::toString)
                .collect(Collectors.toCollection(CustomTree::new));

        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    private String getParent(String s) {
        return "123123";
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
