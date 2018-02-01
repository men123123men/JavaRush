package com.javarush.task.task03.task0302;
import java.io.PrintWriter;
/* 
Немедленно в печать
*/
public class Solution {
    public  static void  printString(String str){
        PrintWriter myPrnt = new PrintWriter(System.out);
        myPrnt.println(str);
        myPrnt.flush();
    }

    public static void main(String[] args) {
        printString("Hello Amigo!");
    }
}
