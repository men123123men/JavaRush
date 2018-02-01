package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        //Map<String, Integer> result = new HashMap<String, Integer>();

    //        for(String currentWord: list )
    //            result.put( currentWord, result.containsKey(currentWord) ? result.get(currentWord)+1 : 1);

        //for(String currentWord: list )
        //    result.merge(currentWord, 1, (oldValue, value) -> oldValue + value);

        //return result;

        return list.stream().collect(Collectors.groupingBy(s -> s, Collectors.summingInt(s -> 1)));
    }
}

