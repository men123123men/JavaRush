package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String fileName = reader.readLine();
    String tegStart = "<" + args[0];
    String tegEnd   = "</"+args[0];
//        String fileName = "/Users/admin/Desktop/tegs.txt";
//        String tegStart = "<span" ;
//        String tegEnd   = "</span";

    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

    StringBuffer lines = new StringBuffer();
    fileReader.lines().forEach(str->lines.append(str));
    String text = lines.toString();                // получаем весь текст
    reader.close();
    fileReader.close();

    ArrayList<Integer> indexOfStart = new ArrayList<>(); // лист с позициями начал
    ArrayList<Integer> indexOfTheEnd = new ArrayList<>(); // лист с позициями концов

    //  < > < < > > < < > < > >  представим наши теги в виде скобок т.е. <span> это <, а </span> это >
    //  1   2 1     3 1   1      максимальное значение counter достигаемое внутри цикла для каждой <

    int counter;    // колличество неправильных комбинаций скобок до нужной >. который ищется для каждой <
    int startIndex=0;
    int innerStartIndex;
    int innerEndIndex;

    while (true) {
        startIndex = text.indexOf(tegStart, startIndex); // это позиция первой НАЙДЕННОЙ<, наша задача ей найти пару
        counter=1;
        if(startIndex==-1) break;         // если тут -1 значит больше < в нашем тексте нету
        indexOfStart.add(startIndex++);   // а если позиция все-таки не -1, знасит добавляем в наш лист позиций начал

        innerEndIndex = startIndex; // эти две переменные нужны нам чтобы отыскать индекс конца сообветствующий
        innerStartIndex = startIndex; // найденному уже индексу начала(они будут отсчитываться от индекса начала)
        while (counter>0){
            innerEndIndex = text.indexOf(tegEnd, innerEndIndex);      // индекс ближайшей > к НАЙДЕННОЙ<
            innerStartIndex = text.indexOf(tegStart, innerStartIndex);// индекс ближайшей < к НАЙДЕННОЙ<

            if(innerStartIndex==-1) break;    // если за НАЙДЕННОЙ< больще нет < значит мы все нашли к этому моменту

            if ( innerEndIndex < innerStartIndex ) {  // "хороший" случай : НАЙДЕННАЯ< > <
                counter--;
                innerEndIndex++;
            }
            else {                         // "плохой" случай : НАЙДЕННАЯ< < >
                counter++;
                innerStartIndex++;
            }
        }
        indexOfTheEnd.add(text.indexOf(">", innerEndIndex)+1);  // поиск позиции закрывающей конца закрывающего тега
    }
    for(int i =0;i<indexOfStart.size();i++)
        System.out.println(text.substring(indexOfStart.get(i),indexOfTheEnd.get(i)));


//
//    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
//    String path  = consoleReader.readLine();
//    consoleReader.close();
//    BufferedReader fileReader = new BufferedReader(new FileReader(path));
//    StringBuilder stringBuilder = new StringBuilder();
//    while (fileReader.ready()){
//        stringBuilder.append(fileReader.readLine());
//    }
//    fileReader.close();
//    String data = stringBuilder.toString();
//
//    String startTag = "<" + args[0];
//    String endTag = "</" + args[0] + ">";
//    int startTagIndex;
//    int endTagIndex;
//    int tempStartTagIndex = 0;
//    while(tempStartTagIndex != -1){
//        startTagIndex = data.indexOf(startTag, tempStartTagIndex);
//        if(startTagIndex == -1 ){
//            return;
//        }
//        endTagIndex = data.indexOf(endTag, startTagIndex);
//
//        tempStartTagIndex = data.indexOf(startTag, startTagIndex + 1);
//        if(tempStartTagIndex < endTagIndex && tempStartTagIndex != -1){
//            endTagIndex = data.indexOf(endTag, endTagIndex + 1);
//        }
//
//        System.out.println(data.substring(startTagIndex, endTagIndex + endTag.length()));
//    }






















    }
}
