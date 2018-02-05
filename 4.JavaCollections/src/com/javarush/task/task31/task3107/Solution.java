package com.javarush.task.task31.task3107;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {

    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path path = Paths.get(pathToFile);
            File file = new File(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(path),Files.isExecutable(path),Files.isDirectory(path),Files.isWritable(path));
        } catch (Exception exc){
            fileData = new NullFileData(exc);
        }


    }

    public FileData getFileData() {
        return fileData;
    }
}
