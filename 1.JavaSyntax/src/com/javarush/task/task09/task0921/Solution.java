package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> userEnter = new ArrayList<>();
        try {
            while (true)
                userEnter.add(Integer.parseInt(reader.readLine()));
        } catch (NumberFormatException e) {
            for(int currentEnteredNumber : userEnter)
                System.out.println(currentEnteredNumber);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

