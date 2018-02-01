package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

InputStream fis1 = null;
OutputStream fos1 = null;
InputStream fis2 = null;

try{
    String firstFileName = scanner.nextLine();
    String secondFileName = scanner.nextLine();

    fis1 = new FileInputStream(firstFileName);
    fos1 = new FileOutputStream(firstFileName);
    fis2 = new FileInputStream(secondFileName);

    byte[] fis = new byte[fis1.available()];  // массив в который перепишем содержимое 1ого файла

    fis1.read(fis);          // замисываем содержимое 1ого файла в массив

    while(fis2.available()>0)     // затираем начало 1ого файла содержимым 2ого
        fos1.write(fis2.read());

    fos1.write(fis);          // в 1ом файле дозаписываем к концу содержимого 2ого файла(который к этому моменту
                            // уже весь в 1ом) содержимое массива(т.е. изначальный 1ый файл)

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        fis1.close();
        fos1.close();
        fis2.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
}
