package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    private static List<Integer> replica = new ArrayList<>();

    public static void main(String[]args) {
        long start = System.currentTimeMillis();
        int[] array = getNumbers(100_000_000);
        long end = System.currentTimeMillis() - start;
        long memore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");
        System.out.println("Time = " + sdf.format(new Date(end)));
        System.out.println("Memory = " + memore / 1024+"KB");

        Arrays.stream(array)
                .distinct()
                .forEach(v->System.out.print(v + " "));
    }

    public static int[] getNumbers(long N) {
        for (int i = 1; i <= N; i++){
            if (isNumberUnique(i)) {
                int sumOfPowers = sum(i);
                if (sum(sumOfPowers) == sumOfPowers)    //if (isArmstrongNumber(sumOfPowers))
                    replica.add(sumOfPowers);

            }
        }

        int[] result = new int[replica.size()];
        for (int i = 0; i < replica.size(); i++)
            result[i] = replica.get(i);


        return result;
    }

    private static boolean isArmstrongNumber(int number) {
        if (sum(number) == number)
            return true;
        return false;
    }
    private static boolean isNumberUnique(int number) {
        int lastDigit = 0;
        int currentDigit;

        while (number > 0) {
            currentDigit = number % 10;
            if (lastDigit > currentDigit)
                return false;
            lastDigit = currentDigit;
            number /= 10;
        }

        return true;
    }

    public static int sum(int a) {       // вычисляет Армстронгову сумму
        int addition = 0;
        //int d = ("" + a).length();       // тут чуть можно ускориться в 1.1 раза и сэкономить 2/3 памяти
        int d = length(a);
        int b = a % 10;
        while (a >= 1) {
            //addition += Math.pow(b, d);  // и тут можно чуть ускориться
            addition += stepen(d,b);
            a /= 10;
            b = a % 10;
        }
        return addition;
    }
    public static long stepen(int exponent, long base ) { // возвожу число в степень
        long result = base;
        for (int i = 1; i < exponent; i++)
            result *= base;
        return result;
    }
    public static int length(int number){
        int length = 0;
        while(number>=1){
            number/=10;
            length++;
        }
        return length;
    }



}
