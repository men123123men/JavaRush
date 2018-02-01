package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //кладем данные в строку
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');

        //Оборачиваем строку в класс ByteArrayInputStream
        //подменяем in

        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (reader.ready())
            System.out.println(reader.readLine());

        reader.close();

    }
}


//
//
//import java.io.*;
//import java.util.*;
////import com.bruceeckel.util.*;
//
//public class DirList {
//    public static void main(String[] args) {
//        File path = new File(".");
//        String[] list=null;
//        if(args.length == 0)
//            list = path.list();
////        else
////            list = path.list(new DirFilter(args[0]));
//        Arrays.sort(list); //, new AlphabeticComparator());
//        for(int i = 0; i < list.length; i++)
//            System.out.println(list[i]);
//    }
//
//
//class DirFilter implements  FilenameFilter {
//    String afn;
//    DirFilter(String afn) { this.afn = afn; }
//    @Override
//    public boolean accept(File dir, String name) {
//        // Получение информации о пути:
//        String f = new File(name).getName();
//        return f.indexOf(afn) != -1;
//    }
//} ///:~ Класс DirFilter “реализует” interface FilenameFilter. Полезно посмотреть, насколько прост FilenameFilter interface:
//
//public interface FilenameFilter {
//    boolean accept(File dir, String name);
//}
//
//}