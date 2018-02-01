package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
public Person read()  {
    String[] lineElements = fileScanner.nextLine().split(" ",4);

    //Date date = new Date(Integer.parseInt(lineElements[5]),Integer.parseInt(lineElements[4]),Integer.parseInt(lineElements[3]));

    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");//31 12 1950
    Date birthDate= null;
    try {
        birthDate = sdf.parse(lineElements[3]);
    } catch (ParseException e) { e.printStackTrace(); }
    return new Person(lineElements[0], lineElements[1],lineElements[2],birthDate);
}

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }


    }
}
