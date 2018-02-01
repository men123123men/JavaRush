package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    InputStream fis = null;
    OutputStream fos2 = null;
    OutputStream fos3 = null;

    try{
        fis = new FileInputStream(scanner.nextLine());
        fos2 = new FileOutputStream(scanner.nextLine());
        fos3 = new FileOutputStream(scanner.nextLine());

        int halfOfText = fis.available()/2;

        while (fis.available()>0){

            if( fis.available() > halfOfText)
                fos2.write(fis.read());
            else
                fos3.write(fis.read());
        }
    } catch (FileNotFoundException exc) {
        exc.printStackTrace();
    } catch ( IOException exc ) {
        exc.printStackTrace();
    } finally {
        try{
            fis.close();
            fos2.close();
            fos3.close();
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
}
