package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(reader.nextLine());
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            while (fileInputStream.available() > 0)
                list.add(fileInputStream.read());


            for(int bYTe:list) {
                if (map.containsKey(bYTe))
                    map.replace(bYTe, map.get(bYTe) + 1);
                else
                    map.put(bYTe, 1);
            }
            //map.forEach((k,v)-> System.out.println(k+") "+v));

            if (!map.isEmpty()) {
                int minCount = Collections.min(map.values());

                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                    if (pair.getValue() == minCount)
                        System.out.print(pair.getKey() + " ");
            }

        } catch (FileNotFoundException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();
        } finally {
            reader.close();
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
