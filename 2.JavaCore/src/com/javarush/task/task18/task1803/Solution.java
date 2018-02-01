package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //String fileName = scanner.nextLine();
        String fileName = "/Users/admin/Desktop/красивые шрифты на мак.txt";
        InputStream fis = null;
        Map<Integer,Integer> mapOfCounts = new HashMap<>();
        try{
            fis = new FileInputStream(fileName);
            while(fis.available()>0){
                int currentByte = fis.read();
                if (!mapOfCounts.containsKey(currentByte))
                    mapOfCounts.put(currentByte,1);
                else
                    mapOfCounts.replace(currentByte,mapOfCounts.get(currentByte)+1);
            }
            mapOfCounts.forEach((k,v)-> System.out.println(k+") "+v));

            int maxCount = 0;
            for (int currentCount : mapOfCounts.values())
                maxCount = Integer.max(currentCount, maxCount);

            for(Map.Entry<Integer,Integer> pair:mapOfCounts.entrySet())
                if(pair.getValue()==maxCount)
                    System.out.print(pair.getKey()+" ");

        } catch(FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc){
            exc.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
