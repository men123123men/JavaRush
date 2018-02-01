package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) {
        InputStream fis=null;
        int englishCharsCount=0;
        int englishCharsCount2=0;

        String fileName = "/Users/admin/Desktop/красивые шрифты на мак.txt";
        try{
            fis= new FileInputStream(fileName); // args[0]
            while(fis.available()>0){
                char c = (char) fis.read();
                if (c>='A'&&c<='Z'||c>='a'&&c<='z') // if (c>='A'&&c<='z'&&!(c>'Z'&&c<'a'))
                    englishCharsCount++;
                if (c>='A'&&c<='z'^(c>'Z'&&c<'a')) //
                    englishCharsCount2++;
            }
            System.out.println(englishCharsCount+"\n"+englishCharsCount2);






        } catch (FileNotFoundException exc ) { exc.printStackTrace();
        } catch (IOException exc) { exc.printStackTrace();
        } finally {
            try{
                fis.close();
            } catch(IOException exc){
                exc.printStackTrace();
            }
        }
    }
}
