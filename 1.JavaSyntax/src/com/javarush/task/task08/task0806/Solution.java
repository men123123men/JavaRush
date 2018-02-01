package com.javarush.task.task08.task0806;

import java.util.Date;

/* 
Коллекция HashMap из Object
*/

public class Solution {
    public static void main(String[] args) throws Exception {

            Date startTime = new Date();

            Date endDate = new Date(startTime.getTime() + 50);

            Thread.sleep(10);  // ждем

            Date currentTime = new Date();

            if (currentTime.after(endDate))//проверяем что время currentTime после endDate
                System.out.println("End time!");

        }


    }
