package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat putputFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

            Date date = inputFormat.parse(reader.readLine());
            String modifiedDateForman = putputFormat.format(date).toUpperCase();

            System.out.println(modifiedDateForman);

        } catch (Exception e) {
            System.out.println("Неверный формат даты. Введите согласно примеру: 08/18/2013");
            main(args);
        }
    }
}
