package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)  {

        Solution someSolution = new Solution();

        try {
            someSolution.joinData();
        } catch (CorruptedDataException e) { System.err.println("IOException in main()"); }


    }

    public void joinData () throws CorruptedDataException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //String firstFileName = reader.readLine();
            //String secondFileName = reader.readLine();
            String firstFileName = "/Users/admin/Desktop/красивые шрифты на мак.txt";


            BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(firstFileName)));
            //BufferedReader readerFile = new BufferedReader(new FileReader(firstFileName));

            //String oneLineOfTextFile;      while (oneLineOfTextFile = readerFile.readLine()) != null) {}
            while (readerFile.ready())
                allLines.add(readerFile.readLine());

            InputStream inStream = new FileInputStream(firstFileName);
            while (inStream.available() > 0)
            {
                int data = inStream.read(); //читаем один байт из потока для чтения

            }













            allLines.forEach(System.out::println);
//
//            BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(secondFileName)));
//            String strLineOfSecondFile;
//            while ((strLineOfSecondFile = br2.readLine()) != null){    //
//                //System.out.println(strLine);
//                allLines.add(strLineOfSecondFile);
//            }
//
//            boolean notContainAll = false;
//            for(String currentLine: forRemoveLines) {
//                if (!allLines.contains(currentLine)) {
//                    notContainAll = true;
//                    break;
//                }
//            }
//            if(notContainAll){
//                allLines.clear();
//                throw new CorruptedDataException();
//            }else {
//                for(String currentLine: forRemoveLines){
//                    allLines.remove(currentLine);
//                }
//            }






        } catch (FileNotFoundException e) { System.err.println("FileNotFoundException in joinData()"); }
          catch (IOException e) { System.err.println("IOException in joinData()"); }
    }
}
