package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputStream fis = null;
        OutputStream fos =null;

        try{
            fis = new FileInputStream(scanner.nextLine());
            fos = new FileOutputStream(scanner.nextLine());

            int[] chars = new int[fis.available()];

            while(fis.available()>0)
                chars[fis.available()-1] = fis.read();

            for (int currentChar: chars)
                fos.write(currentChar);

        } catch (FileNotFoundException e) { e.printStackTrace();
        } catch (IOException exc){ exc.printStackTrace();
        } finally {
            try{
                fis.close();
                fos.close();
            } catch (IOException exc){ exc.printStackTrace(); }
        }
    }
}
