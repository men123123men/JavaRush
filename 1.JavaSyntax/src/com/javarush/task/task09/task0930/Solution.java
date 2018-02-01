package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

public static void sort(String[] array) {
    //напишите тут ваш код
    List<Integer> numbers= new ArrayList<>();
    List<String > words= new ArrayList<>();
    for(String currentStr: array){   // тут я наполняю элементами из array два ArrayList'a
        if (isNumber(currentStr)) numbers.add(Integer.parseInt(currentStr));
        else words.add(currentStr);
    }
    for(int i = numbers.size();i>0;i--){// сортирую ArrayList с числами
        for (int j = 0; j<i-1;j++){
            if (numbers.get(j)<numbers.get(j+1)){
                int tem = numbers.get(j);
                numbers.set(j,numbers.get(j+1));
                numbers.set(j+1,tem);
            }
        }
    }
    for(int i = words.size();i>0;i--){// сортирую ArrayList со словами
        for (int j = 0; j<i-1;j++){
            if (isGreaterThan(words.get(j),words.get(j+1))){
                String tem = words.get(j);
                words.set(j,words.get(j+1));
                words.set(j+1,tem);
            }
        }
    }
    // а теперь перезаписываю значения в array значениями из отсортированных ArrayList'ов
    for(int i = 0, numberIndex = 0, wordIndex = 0; i<array.length;i++){
        if (isNumber(array[i])) array[i] = numbers.get(numberIndex++).toString();
        else array[i] = words.get(wordIndex++);
    }
}

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
