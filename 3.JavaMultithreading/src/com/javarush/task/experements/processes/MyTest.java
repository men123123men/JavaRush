package com.javarush.task.experements.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("top");

        try{
            Process topProcess = processBuilder.start();

            Runnable runnable = ()-> {
                String line;
                Thread currentThread = Thread.currentThread();
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(topProcess.getInputStream()))) {
                    while (((line = reader.readLine()) != null)&&!currentThread.isInterrupted())
                        System.out.println(line);
                } catch (IOException exc){
                    exc.printStackTrace();
                }
            };

            Thread threadForProcess = new Thread(runnable);
            threadForProcess.start();

            Scanner scanner = new Scanner(System.in);
            while(true)
                if(scanner.nextLine().equals("exit")) {
                    threadForProcess.interrupt();
                    break;
                }

        } catch (IOException exception){
            exception.printStackTrace();
        }


    }
}
