package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbersM(long N) {
        long[] result=null;

        List<Long> arrayOfResult = new LinkedList<>();
        long enteredNumder;
        int countOfDigits;

        for(long l =1; l<N;l++){
            enteredNumder = l;
            countOfDigits = (int) Math.ceil(Math.log10(enteredNumder+0.5));
            //System.out.println("countOfDigits = "+countOfDigits);
            int currentDigit;
            int sumOfPowers=0;
            long tempNumder = enteredNumder;
            for(int currentPower = countOfDigits-1; currentPower>=0; currentPower--){
                currentDigit = (int) (tempNumder/Math.pow(10,currentPower));
                //currentDigit =(int) tempNumder%10;

                //System.out.print(currentDigit);
                tempNumder %= Math.pow(10,currentPower);                     // медленное
                sumOfPowers += Math.pow(currentDigit,countOfDigits);         // место


            }
//        System.out.println("enteredNumder = "+enteredNumder);
//        System.out.println("sumOfPowers = "+sumOfPowers);

            if(enteredNumder == sumOfPowers) {
                arrayOfResult.add(enteredNumder);
//                System.out.println(enteredNumder+"\t Ok!");
            }
        }
        result = new long[arrayOfResult.size()];
        for(int i =0; i<result.length;i++)
            result[i]=arrayOfResult.get(i);


        return result ;
    }

    static ArrayList<Long> replica = new ArrayList<>();
    public static long[] getNumbers(long N) {  //метод который дается по заданию
        for (long i = 1; i <= N; i++)
            if (summa(i) == i)
                replica.add(i);
        long[] result = new long[replica.size()];
        for (int i = 0; i < replica.size(); i++)
            result[i] = replica.get(i);
        return result;
    }

    public static long summa(long a) { // считаю сумму числа по "системе армстронга" будь он неладен
        int addition = 0;
        int d = lengthNumber(a);
        long  b = a % 10;
        while (a >= 1) {
            addition += stepen(d, b);
            a /= 10;
            b = a % 10;
        }
        return addition;
    }

    public static int lengthNumber(long a) {  //считаю длину числа
        int b = 0;
        while (a >= 1) {
            b++;
            a /= 10;
        }
        return b;
        //return (int) Math.ceil(Math.log10(a+0.5));// в 1.5 раза медленне
    }
    public static long stepen(int a, long b ) { // возвожу число в степень
        long result = b;
        for (int i = 1; i < a; i++)
            result *= b;
        return result;
//        return (long) Math.pow(b,a);         // в 16 раза медленне
    }

    public static void main(String args[]) {
//        long memoryStart = Runtime.getRuntime().freeMemory();
//        long timeStart = System.currentTimeMillis();
//        long[] resultLongs = getNumbersM(1_000_000);
//        for(long l :resultLongs) System.out.print(l+" ");
//        long memoryEnd = Runtime.getRuntime().maxMemory();
//        long timeEnd = System.currentTimeMillis();
//
//
//        System.out.printf("\n\nTime need to create the arrray = %,d ms \n", (timeEnd - timeStart));
//        System.out.printf("Used Memory in JVM: %,d Mb ", (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory())/1024/1024);
//        System.out.printf("(%,d byte)\n\n\n", (memoryEnd - memoryStart));
//
//        memoryStart = Runtime.getRuntime().freeMemory();
//        timeStart = System.currentTimeMillis();
//        resultLongs = getNumbers(1_000_000);
//        for(long l :resultLongs) System.out.print(l+" ");
//        memoryEnd = Runtime.getRuntime().maxMemory();
//        timeEnd = System.currentTimeMillis();
//
//
//        System.out.printf("\n\nTime need to create the arrray = %,d ms \n", (timeEnd - timeStart));
//        System.out.printf("Used Memory in JVM: %,d Mb ", (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory())/1024/1024);
//        System.out.printf("(%,d byte)\n", (memoryEnd - memoryStart));
//

    }
}
