package com.javarush.task.experements.FileInputStr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//w  w  w .j  a va2 s .  c  o m
public class Main {
    public static void main(String[] args) {



        char[] cbuf = new char[1500];
        int lengthOfRead = 500;
        int offset = 500;
        File fileForReading = new File("/Users/admin/Desktop/красивые шрифты на мак.txt");
        try(FileInputStream fis = new FileInputStream(fileForReading);
            InputStreamReader isr = new InputStreamReader(fis)) {

            // reads into the char buffer
            lengthOfRead = isr.read(cbuf,offset, cbuf.length - offset);

        } catch (IOException e) {
            e.printStackTrace();
        }


        // prints the number of characters
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!Number of characters read: " + lengthOfRead +"\n");

        // for each character in the character buffer
        for (char c : cbuf) {
            // for empty character
//            if (((int) c) == 0)
//                c = '-';
            if (((int) c) != 0)
                System.out.print(c);
        }

    }
}