package com.javarush.task.task17.task1705;

import java.util.ArrayList;
import java.util.List;

/* 
Сад-огород
*/

public class Solution {


    public static void main(String[] args) {

    }

    public static class Garden {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit) {
            fruits.add(index,fruit);
        }
        public synchronized void removeFruit(int index){
            fruits.remove(index);
        }
        public synchronized void addVegetable(int index, String vegetable){
            vegetables.add(index,vegetable);
        }
        public synchronized void removeVegetable(int index){
            vegetables.remove(index);
        }

//        — который добавляет параметр fruit в лист fruits на позицию index
//2. Создай метод public void removeFruit(int index) — который удаляет из fruits элемент с индексом index
//3. Создай метод public void addVegetable(int index, String vegetable) — который добавляет параметр vegetable в лист vegetables на позицию index
//4. Создай метод public void removeVegetable(int index)

    }
}
