package com.javarush.task.task18.task1813;

import java.io.*;
import java.util.Date;

public class Test {
public static void main(String[] args) throws IOException {

    File file = new File("/Users/admin/Desktop/Test.txt");

    //File file = File.createTempFile("Temp.txt",null);

    System.out.printf("Файл размера %d байт %s в : %s%nВот, его содержимое:%n",
            file.length()+110,(file.createNewFile()?"создан":"находится"),file.getAbsolutePath());


    BufferedReader br = new BufferedReader(new FileReader(file));

    FileOutputStream fos1 = new FileOutputStream(file,true);
    FileOutputStream fos2 = new FileOutputStream(fos1.getFD()); // запись будет осужествляться в тот же файл!!!!


    Date current = new Date();

    fos1.write(String.format("Whrite to File at:\t\t\t\t%tc%n",current).getBytes());        fos1.flush();
    fos2.write(String.format("Whrite to FileDescriptor at:\t%tc%n%n",current).getBytes());  fos2.flush();

    br.lines().forEach(System.out::println);
}
}
