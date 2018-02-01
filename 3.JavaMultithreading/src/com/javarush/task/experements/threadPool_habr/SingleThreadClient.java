package com.javarush.task.experements.threadPool_habr;

public class SingleThreadClient {
    public static void main(String[] args){

        Counter counter = new Counter();
        long start = System.nanoTime();
        long end;
        long timeRange=0;

        double value = 0;
        for(int i=1;i<=10;i++){
            for (int j=0;j<40;j++)
                value += counter.count(j);
            end = System.nanoTime();
            timeRange+=end-start;
            //System.out.printf("%d итерация. Пройденное время: % ,d %n",i,end-start);
            start = end;
        }
        System.out.printf("Полное время: % ,d секунды %n",timeRange/1_000_000);

        long start2 = System.nanoTime();
        double value2=0;
        for(int k=0;k<400;k++)
            value2+=counter.count(k);
        System.out.printf("Время составило: %,d секунды %n",(System.nanoTime()-start2)/1_000_000);


    }
}
