package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OutputStream fos1 = null;
        InputStream fis2 = null;
        InputStream fis3 = null;

        try{
            fos1 = new FileOutputStream(scanner.nextLine(), true);
            fis2 = new FileInputStream(scanner.nextLine());
            fis3 = new FileInputStream(scanner.nextLine());
            while(fis2.available()>0)
                fos1.write(fis2.read());
            while(fis3.available()>0)
                fos1.write(fis3.read());



        } catch (FileNotFoundException exc) { exc.printStackTrace();
        } catch (IOException exc) { exc.printStackTrace();
        } finally {
            try {
                fos1.close();
                fis2.close();
                fis3.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
