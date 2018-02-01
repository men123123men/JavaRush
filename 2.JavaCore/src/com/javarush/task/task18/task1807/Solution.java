package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputStream fis = null;
        int commasCount=0;
        try{
            fis = new FileInputStream(scanner.nextLine());

            while(fis.available()>0)
                if(fis.read()==(int)',')
                    commasCount++;
            System.out.println(commasCount);




        } catch (FileNotFoundException exc){
            exc.printStackTrace();
        } catch (IOException exc ){
            exc.printStackTrace();
        } finally {
            try{
                fis.close();
            } catch (IOException exc ){
                exc.printStackTrace();
            }
        }









    }
}
