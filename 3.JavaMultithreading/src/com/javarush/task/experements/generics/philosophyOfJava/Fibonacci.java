package com.javarush.task.experements.generics.philosophyOfJava;

interface Generator<U>{
    U next();
}

public class Fibonacci implements Generator<Integer>{
    private int count =0;

    public Fibonacci() { }



    @Override
    public Integer next() {
        return fib(count++);
    }
    private int fib(long n){
        return n<2? 1 : fib(n-1)+fib(n-2);
    }

//    private long[] cash = new long[10];
//    public long getNext(){
//        if (++count>cash.length-1)
//            cash = Arrays.copyOf(cash, (int) (1.5 * cash.length));
//        return cash[count] = count<2? 1: cash[count-1]+cash[count-2];
//    }


    public static void main(String[] args){
//        Fibonacci fib = new Fibonacci();
//        for(int i =1; i<=90; i++)
//            System.out.printf("%03d) %20d%n",i,fib.getNext());

        Fibonacci fibRecurs = new Fibonacci();
        for(int i =1; i<=90; i++)
            System.out.printf("%03d) %20d%n",i,fibRecurs.next());

    }



}
