package com.javarush.task.task06.task0622;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        ArrayList list=new ArrayList();
        for (int i=0;i<5;i++){
            int x=scan.nextInt();
            list.add(x);
        }
        Collections.sort(list);
        for (int i=0;i<5;i++)
            System.out.println(list.get(i));
    }
}
