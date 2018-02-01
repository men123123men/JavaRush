package com.javarush.task.experements.ioinjava;

import java.io.File;
import java.io.FilenameFilter;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list=null;
        //if(args.length == 0)
        list = path.list();
//        else
//            list = path.list(new DirFilter(args[0]));
        //Arrays.sort(list);

        for(String fileName: list)
            System.out.println(fileName);
    }

        //f.list((File a1, String a2) -> {return false;});


    class DirFilter implements FilenameFilter {
        String afn;
        DirFilter(String afn) { this.afn = afn; }
        @Override
        public boolean accept(File dir, String name) {
            // Получение информации о пути:
            String f = new File(name).getName();
            return f.indexOf(afn) != -1;
        }
    } ///:~ Класс DirFilter “реализует” interface FilenameFilter. Полезно посмотреть, насколько прост FilenameFilter interface:

//    public interface FilenameFilter {
//        boolean accept(File dir, String name);
//    }

}