package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static{
        try(InputStreamReader strReader = new InputStreamReader(new FileInputStream(Statics.FILE_NAME));
            BufferedReader reader = new BufferedReader(strReader)) {

            while (reader.ready())
                lines.add(reader.readLine());

        } catch (FileNotFoundException exc){
            exc.printStackTrace();
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
//        for (String str:lines)
//            System.out.println(str);
//
//        System.out.println(lines.size());
    }
}
