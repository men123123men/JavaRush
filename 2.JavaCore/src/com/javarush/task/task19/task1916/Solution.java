package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader fileNamesReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader1 = new BufferedReader( new FileReader(fileNamesReader.readLine()));
//        BufferedReader reader2 = new BufferedReader( new FileReader(fileNamesReader.readLine()));

        BufferedReader reader1 = new BufferedReader( new FileReader("/Users/admin/Desktop/numbers.txt"));
        BufferedReader reader2 = new BufferedReader( new FileReader("/Users/admin/Desktop/numbers2.txt"));
        List<String> strings1 = reader1.lines().collect(Collectors.toList());
        List<String> strings2 = reader2.lines().collect(Collectors.toList());

        //System.out.println(reader1.lines().;
        fileNamesReader.close();
        reader1.close();
        reader2.close();

        int count1 = 0, count2 = 0;

        while (count1 + count2   <   strings1.size() + strings2.size()){

            if(strings1.size()==count1)
                lines.add(new LineItem(Type.ADDED, strings1.get(count2++)));
            else if(strings2.size()==count2)
                lines.add(new LineItem(Type.REMOVED, strings1.get(count1++)));

            else if (strings1.get(count1).equals(strings2.get(count2))) {
                lines.add(new LineItem(Type.SAME, strings1.get(count1)));
                count1++;
                count2++;
            }
            else if(strings1.get(count1).equals(strings2.get(count2+1)))
                lines.add(new LineItem(Type.ADDED, strings2.get(count2++)));
            else if(strings1.get(count1+1).equals(strings2.get(count2)))
                lines.add(new LineItem(Type.REMOVED, strings1.get(count1++)));
        }
        System.out.println("Begin");
        lines.forEach(System.out::println);  // LineItem.toString() надо расклментировать внизу
        System.out.write("end".getBytes(),0,3);
    }
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
//        @Override
//        public String toString() { return type+" "+line; }
    }
}
