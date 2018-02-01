package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    private String fileName;

public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
    super(fileName);
    boolean condition;
    int choice = 0;             // сделай свой выбор
    switch (choice){
        case 0:
            condition = fileName.endsWith(".txt"); break;
        case 1:
            condition = fileName.matches(".*\\.txt$"); break;
        case 2:
            condition = fileName.substring(fileName.length() - 4).equals(".txt"); break;
        case 3:
            condition = fileName.substring(fileName.lastIndexOf(".")).equals(".txt"); break;
        case 4:
            condition = fileName.lastIndexOf(".txt") == fileName.length() - 4; break;
        case 5:
            condition = fileName.regionMatches(true,(fileName.length()-4),".txt",0,4); break;
        default:
            String[] tmp = fileName.split("\\.");
            condition = tmp[tmp.length-1].equals("txt");
    }
    if (!condition){
        super.close();
        throw new UnsupportedFileNameException();
    }
    this.fileName = fileName;
}
    public static void main(String[] args) { }
}

