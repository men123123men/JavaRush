package com.javarush.task.experements.algoritms;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        // [8, 0, 4, 7, 3, 7, 10, 12, -3],0,8
        //завершить выполнение если длина массива равна 0
        if (array.length == 0) return;

        //завершить выполнение если уже нечего делить
        if (low >= high) return;

        // выбрать опорный элемент
        int middle = low + (high - low) / 2; // 4
        int opora = array[middle]; // array[4] = 3

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high; // 0, 8
        while (i <= j) {
            while (array[i] < opora) // i=0 -> i=0
                i++; // поднимаем нижний бегунок до числа большего или равного опорному

            while (array[j] > opora) // j=8 -> j=8
                j--;

            if (i <= j) {//меняем местами    // true
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;      // [-3, 0, 4, 7, 3, 7, 10, 12, 8]
                i++;             // i=1
                j--;             // j=7
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)  quickSort(array, low, j);

        if (high > i) quickSort(array, i, high);
    }
    public static void sort(int[] array){ quickSort(array,0,array.length-1); }

    public static void main(String[] args) {
        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };

        System.out.printf("Было  %s%n",Arrays.toString(x));
        sort(x);
        System.out.printf("Стало %s%n",Arrays.toString(x));

    }
}