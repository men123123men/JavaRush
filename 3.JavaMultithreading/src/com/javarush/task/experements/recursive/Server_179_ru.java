package com.javarush.task.experements.recursive;

import java.io.File;
import java.util.Arrays;

public class Server_179_ru {
    public static int ack(int m,int n){
//        return m==0?n+1:n==0?akkerman(m-1,n):akkerman(m-1,akkerman(m,n-1));

        if (m == 0)    return n + 1;
        if (n == 0)    return ack (m - 1, 1);
        return ack (m - 1, ack (m, n - 1));

    }
    public static boolean exectPowerOf2(int i){
        return i==1 || i % 2 == 0 && exectPowerOf2(i / 2);
    }

    public static int countOfDigits(int n){
        if (n==1) return 1;
        return n%10+countOfDigits(n/10);
    }
    public static void reversOrderNumber(int n){
        if(n==0) return;
        System.out.print(n%10);
        reversOrderNumber(n/10);

    }
    public static int reversNumder(int n){
        System.out.println("exponent "+exponent(n));
        System.out.println("power "+power(n));
        return replaseDigit(0,n,exponent(n),power(n));
    }
    private static int replaseDigit(int index, int numder,int exponent,int power){
        if(index==power) return numder;
        System.out.println(numder);
        numder = (numder+exponent*(numder%10))/10;
        return replaseDigit(index+1,numder,exponent,power);
    }
    private static int exponent(int n){
        return n==0? 1: 10*exponent(n/10);
    }
    private static int power(int n){
        return n<10? 1: 1+power(n/10);
    }


    public static String normalOrderDigits(int n){
        if(n<10) return Integer.toString(n);
        return normalOrderDigits(n/10)+" "+n%10;

    }
    public static void main(String[] args){
//        //System.out.println("ere");
////        System.out.println(ack(4,1));
//        System.out.println(exectPowerOf2(1));
//        System.out.println(countOfDigits(123456));
//        reversOrderNumber(123456);
//        System.out.println();
//        System.out.println(normalOrderDigits(123456));
//
//        System.out.println(power(10));
//        System.out.println("ПОЕХАЛИ!");
//        System.out.println(reversNumder(45678));
        File file = new File("/Users");
        Arrays.stream(file.listFiles()).forEach(System.out::println);
    }

}
