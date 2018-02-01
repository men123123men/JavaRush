package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public void writeObject(ObjectOutputStream out) throws IOException{
            throw new NotSerializableException("Not today");
        }
        public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
