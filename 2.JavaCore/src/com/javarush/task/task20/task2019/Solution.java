package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);


        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
        loadedObject.getMap().forEach((k,v)-> System.out.printf("%s => %s\n",k,v));
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() { return m; }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() { return m.size(); }
}
