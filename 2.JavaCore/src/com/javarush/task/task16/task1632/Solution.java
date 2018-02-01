package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
public static List<Thread> threads = new ArrayList<>(5);
static {
    threads.add(new FirstThread());
    threads.add(new SecondThread());
    threads.add(new ThirdThread());
    threads.add(new FourthThread());
    threads.add(new FifthThread());
}
public static class FirstThread extends Thread {
    @Override
    public void run() {
        while(true){}
    }
}
public static class SecondThread extends Thread {
    @Override
    public void run() {
        while(true){
            if (isInterrupted()){
                System.out.println("InterruptedException");
            }
        }
    }
}
public static class ThirdThread extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("Ура");
            try {
                sleep(500);
            } catch (InterruptedException e) { }
        }
    }
}
public static class FourthThread extends Thread implements Message{
    @Override
    public void run() {
        while (!isInterrupted()){}
    }
    @Override
    public void showWarning() {
        interrupt();
    }
}
public static class FifthThread extends Thread {
    @Override
    public void run() {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String currentStr;
        int result=0;
        try{
            while (!(currentStr = reader.readLine()).equals("N"))
                result += Integer.parseInt(currentStr);
            System.out.println(result);
        }catch ( IOException exc){ System.err.println("Все накрылось!"); }
    }
}
public static void main(String[] args) throws InterruptedException {
    //threads.forEach(thread -> thread.start());
}
}