package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String ageStr = reader.readLine();
        int ageInt = Integer.parseInt(ageStr);
        System.out.println(name+" захватит мир через "+ageInt+" лет. Му-ха-ха!");
    }
}
