package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        char character;                             // считываемый символ
        StringBuilder word = new StringBuilder();   // строчка символов до ближайшего пробела (своего рода маленький буфер)
        float floatNumber;                        // число преобразованное из нашей строчки
        int roundIntNumber;                      // округленное число(которое переведем в String чтобы потом перевести в byte[]
                                    // чтобы уже этот массив записать в файл
        InputStream fis = new FileInputStream(scanner.nextLine());
        OutputStream fos = new FileOutputStream(scanner.nextLine());
        while (fis.available()>0) {

            character = (char) fis.read();      // считываем символ

            if (character != ' ')                 // если считали не пробел заносим этот символ в строчку
                word.append(character);

            if (character == ' ' || fis.available() == 0) {     // если счититали пробел или последний символ файла

                floatNumber = Float.parseFloat(word.toString());     // считываем дробное число из нашей строчки

                roundIntNumber = Math.round(floatNumber);         // округляем его до целого

                fos.write(Integer.toString(roundIntNumber).getBytes());  // записываем в файл его битовую последовательность
                fos.write(' ');                      // записываем в файл пробел

                word.delete(0, word.length());     // сбрасывае значение в строчке
            }
        }
        fis.close();
        fos.close();
    }
}
