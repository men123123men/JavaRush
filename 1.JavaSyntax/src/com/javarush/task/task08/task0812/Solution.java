package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        int result = 1;
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
            for (int j = list.size()-1; j >= 0 ; j--) {
                if (j != 0) {
                    if (list.get(i) == list.get(j-1)) {
                        count++;
                        if (result < count)
                            result = count;
                    } else break;
                }
            }
            count = 1;
        }
        System.out.println(result);
    }
}
