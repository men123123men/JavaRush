package com.javarush.task.task17.task1702;

import java.util.ArrayList;
import java.util.List;

/* 
Вместе быстрее? Ща проверим :)
*/

public class Solution {
    public static class SortThread extends Thread{
        @Override
        public void run() { sort(testArray); }
    }
    public static int countThreads = 10;
    public static int[] testArray = new int[1000];     // прямой массив

    static { for (int i = 0; i < Solution.testArray.length; i++)
                testArray[i] = i; }

    public static void main(String[] args) throws InterruptedException {
        StringBuffer expectedResult = new StringBuffer();  // строка с перевернутым массивом, эталон (такую мы пытаемся получить)
        for (int i =  Solution.testArray.length - 1; i >= 0; i--)
            expectedResult.append(i).append(" ");

        initThreads();                                    // переворачиваем массив

        StringBuffer result = new StringBuffer();        // строка с массивом после переворачивания (хреново перевернутая строка)
        for (int i = 0; i < testArray.length; i++)
            result.append(testArray[i]).append(" ");

        System.out.println(result);                      // выводим нашего перевертыша (и замечаем хреновоперевёртнутость)
        System.out.println((result.toString()).equals(expectedResult.toString())); // сравниваем эталон с хреново перевенутой строкой
        System.out.println(expectedResult.equals(result));
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(countThreads);
        for (int i = 0; i < countThreads; i++) threads.add(new SortThread());
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }

    public static synchronized void sort(int[] array) {    //
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = i + 1; j < array.length; j++) {
            //synchronized (testArray) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            //}
        }
    }
}
}

