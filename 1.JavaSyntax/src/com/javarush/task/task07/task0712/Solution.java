package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> enteredStrs = new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String currentSrt;
        int lengthOfCurrentStr;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<10;i++){
            currentSrt = reader.readLine();
            lengthOfCurrentStr = currentSrt.length();
            enteredStrs.add(currentSrt);
            if (lengthOfCurrentStr>maxLength) maxLength = lengthOfCurrentStr;
            if (lengthOfCurrentStr<minLength) minLength = lengthOfCurrentStr;
        }

        for (int i = 0; i<enteredStrs.size();i++){

            if (enteredStrs.get(i).length()==minLength|enteredStrs.get(i).length()==maxLength) {
                System.out.println(enteredStrs.get(i));
                break;
            }


        }
    }
}
