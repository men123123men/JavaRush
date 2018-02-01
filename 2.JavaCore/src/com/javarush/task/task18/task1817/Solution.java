package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
public static void main(String[] args) {
    InputStream fis=null;
    try{
        fis = new FileInputStream(args[0]);

        int fullCount = fis.available();

        int gapCount = 0;

        while(fis.available()>0)
            if (fis.read()==' ')
                gapCount++;

        System.out.printf("%.2f",(double) gapCount/fullCount *100);

    } catch(FileNotFoundException exc){ exc.printStackTrace();
    } catch(IOException exc) { exc.printStackTrace();
    } finally {
        try{
            fis.close();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
}
