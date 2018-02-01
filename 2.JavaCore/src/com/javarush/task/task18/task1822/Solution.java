package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//public class Solution {
//public static void main(String[] args) throws IOException {
//    String fileName = new Scanner(System.in).nextLine();
//    fileName.length();
//
//    BufferedReader br = new BufferedReader( new FileReader(fileName));
////    BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(fileName)));
////    BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
//    String currentLine;
//
//
//    while (br.ready())
//        currentLine = br.readLine();
//    br.close();
//
//
//    Scanner scanner = new Scanner(Paths.get(fileName));
//    String line;
//    while(scanner.hasNextLine())
//        line = scanner.nextLine();
//    scanner.close();
//
//
//    byte[] bytes = Files.readAllBytes(Paths.get(fileName));
//
//    List<String> allLines = Files.readAllLines(Paths.get(fileName));
//
//    Files.lines(Paths.get(fileName)).filter(x-> x.length()>5).forEach(System.out::println);
//
//
//}
//}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader( new FileReader(new Scanner(System.in).nextLine()));
        String currentLine;
        while (bfr.ready()){
            currentLine = bfr.readLine();

            if (currentLine.matches("^"+args[0]+"\\s+.*"))
                System.out.println(currentLine);
//            if(args[0].equalsIgnoreCase(currentLine.split(" ")[0]))
//                System.out.println(currentLine);

        }
        bfr.close();







    }
}