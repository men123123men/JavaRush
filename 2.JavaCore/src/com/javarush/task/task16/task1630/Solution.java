package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    private static BufferedReader readerConsole;

    static{
        readerConsole = new BufferedReader(new InputStreamReader(System.in));
        try {
            //firstFileName = "/Users/admin/Desktop/красивые шрифты на мак.txt";
            firstFileName = readerConsole.readLine();
            secondFileName = readerConsole.readLine();
        } catch (IOException e) {
            System.err.println("Все пропало!");
        }
    }
    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fullFileName;
        String content ="";

        @Override
        public void run() {
            try(BufferedReader readerFile = new BufferedReader(new FileReader(new File(fullFileName)))){
                while (readerFile.ready())
                    content +=readerFile.readLine()+"\n";
            } catch ( IOException  exception){
                System.err.println("Всё накрылось медным тазом!");
                System.exit(0);
            }
        }

        @Override
        public String getFileContent() {
            //          /Users/admin/Desktop/красивые шрифты на мак.txt
            return "["+content+"]";
            //return "["+content.replaceAll("\n", " ")+"]";     // замена всех
            //return "["+content.trim()+"]";            // удаление всяких пробелов сзади
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }



    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }
    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();               //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }
    public interface ReadFileInterface {
        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }

    //add your code here - добавьте код тут
}
