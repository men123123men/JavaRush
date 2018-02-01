package com.javarush.task.experements.lambdas;

import java.util.stream.IntStream;

public class t12Reduce {
    public static void main(String[] args){
        int factorial = IntStream.rangeClosed(1,5)
                .reduce(((left, right) -> left*right))
                .getAsInt();

        int summa = IntStream.rangeClosed(1,9)
                .reduce((left, right) -> left+right)
                .getAsInt();

        int summa2 = IntStream.rangeClosed(1,9)
                .reduce(10,(left, right) -> left+right);

        int summa3 = IntStream.rangeClosed(1,3)
                .reduce((left,right)->left*10+right)
                .getAsInt();


        // String.hashCode()
        int reduse = "123".chars()
                .reduce((left, right) -> left*31+right)
                .getAsInt();
        int formula = ((0*31 +49)*31 +50)*31 +51;
        int formula2 = (int) (0*Math.pow(31,3)+49*Math.pow(31,2)+50*Math.pow(31,1)+51*Math.pow(31,0));
        //System.out.printf("formula : %d%nreduce  : %d%nformula2: %d%n",formula,reduse,formula2);



        int summa4 = IntStream.rangeClosed(1,3)
                //.boxed()
                .reduce(
                        10,       // начальное значение
                        (identity, val) -> identity * val  // внутри воображаемого цикла
                        //, (left, right) -> left *333* right  // вообще игнорируется!!!
                );






        // поиск минимального)
        int minNumber = IntStream.rangeClosed(13,18)
                .reduce((left, right) -> left>right? right:left)
    // Т.е. если следующий элемент меньше, берем его, иначе тот, что есть в данный момент
                .getAsInt();

        int minNumber2 = IntStream.rangeClosed(7,10)
                .reduce(Integer::min)   // таже фигня
                .getAsInt();












    }



}
