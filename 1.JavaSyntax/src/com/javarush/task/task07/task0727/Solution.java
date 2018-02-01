package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> resultArrayLlst = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String modified = s.length()%2==0? s+" "+s : s+" "+s+" "+s;
            resultArrayLlst.add(modified);
        }

        for (int i = 0; i < resultArrayLlst.size(); i++) {
            System.out.println(resultArrayLlst.get(i));
        }
    }
}
