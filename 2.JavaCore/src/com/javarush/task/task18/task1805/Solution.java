package com.javarush.task.task18.task1805;


import java.io.*;

public class Solution {
    public static void main(String[] args) {


        File fileFrom = new File("/Users/admin/Desktop/красивые шрифты на мак.txt");
        File fileTo = new File("/Users/admin/Desktop/красивые шрифты на мак2.txt");

        //if (font.canRead()) System.out.println("File can be read");
        //fileTo.createNewFile();




        InputStream inStream = null;
        OutputStream outStream = null;
        FileReader fr= null;
        InputStream fis = null;
        try {



            inStream = new FileInputStream(fileFrom);
            outStream = new FileOutputStream(fileTo);

            fr = new FileReader(fileTo);
            fis = new FileInputStream(fileTo);

            while (inStream.available() > 0)
                outStream.write(inStream.read());


//
//            byte[] buffer = new byte[10];
//
//            while (inStream.available() > 0) {
//                int count = inStream.read(buffer);
//                outStream.write(inStream.read(buffer));
//            }

            while (fr.ready())
                System.out.print((char) fr.read());

            while(fis.available()>0)
                System.out.print((char) fis.read());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                inStream.close();
                outStream.close();
                fr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }










    }
}
