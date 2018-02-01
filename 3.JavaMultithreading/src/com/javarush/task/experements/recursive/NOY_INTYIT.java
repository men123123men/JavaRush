package com.javarush.task.experements.recursive;

public class NOY_INTYIT {
    public static void main(String[] args){
        for(int n=0;n<30;n++){
            System.out.printf("%2d) a=%7d, b=%7d%n",n,doubleRecursA(n),doubleRecursB(n));
        }
    }
    public static int doubleRecursA(int i){
        switch (i){
            case 0: return 1;
            case 1: return 2;
            default:return doubleRecursA(i-2)+doubleRecursB(i-1);
        }
    }
    public static int doubleRecursB(int i){
        switch (i){
            case 0: return 2;
            case 1: return 1;
            default:return doubleRecursA(i-1)+doubleRecursB(i-2);
        }
    }
}
