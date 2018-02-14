package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        File path = new File(args[0]);
//        File resultFileAbsolutePath = new File(args[1]);
//
//        File resultFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
//        FileUtils.renameFile(resultFileAbsolutePath, resultFile);
//
//        String string = File.separator;
//
//        FileOutputStream fos = new FileOutputStream(resultFile,true); // не убирайте эти 2 строки,
//        fos.close();                      // а то валидацию не сможите пройти
//
//        List<File> allFiles = findFiles(new ArrayList<>(), path);
//
//        allFiles.sort(Comparator.comparing(File::getName));
//
//        fos = new FileOutputStream(resultFile,true);
//        Writer fr = new OutputStreamWriter(fos);
//        BufferedWriter bfr = new BufferedWriter(fr);
//
//        for(File currentFile: allFiles) {
//            for (String stringOfFile : Files.readAllLines(currentFile.toPath()))
//                bfr.write(stringOfFile);
//            bfr.write("\n");
//            bfr.flush();
//        }
//        fos.close();

    }

    public static List<File> findFiles(List<File> list, File inputFile){
        if (inputFile.isDirectory())
            for(File currentFile: inputFile.listFiles())
                findFiles(list, currentFile);

        else if (inputFile.length() <= 50)
            list.add(inputFile);

        return list;
    }
}



