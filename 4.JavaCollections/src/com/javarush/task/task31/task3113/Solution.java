package com.javarush.task.task31.task3113;

/*
Что внутри папки?
*/

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    private int filesCount=0;
    private int directoresCount = 0;
    private long size = 0;

    public int getFilesCount() { return filesCount; }
    public int getDirectoresCount() { return directoresCount; }
    public long getSize() { return size; }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        directoresCount++;
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (directoresCount==0)
            return FileVisitResult.TERMINATE;
        filesCount++;
        size+= Files.size(file);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return directoresCount==0? FileVisitResult.TERMINATE : FileVisitResult.CONTINUE;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String stringPath = scanner.nextLine();
        Path path = Paths.get(stringPath);

        MyFileVisitor fileVisitor = new MyFileVisitor();
        Files.walkFileTree(path,fileVisitor);

        if (fileVisitor.getDirectoresCount()==0){
            System.out.println(stringPath + " - не папка");
        } else {
            System.out.println("Всего папок - " + (fileVisitor.getDirectoresCount() - 1));
            System.out.println("Всего файлов - " + fileVisitor.getFilesCount());
            System.out.println("Общий размер - " + fileVisitor.getSize());
        }
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//
//public class Solution {
//
//    private static int filesCount;
//    private static int dirsCount;
//    private static long filesTotalSize;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));
//
//        Path path = Paths.get(cbr.readLine());
//
//        if (Files.isDirectory(path)) {
//
//            filesCount = dirsCount = 0;
//            filesTotalSize = 0;
//
//            int depth = path.getNameCount() + 1;
//
//            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
//
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    filesCount++;
//                    filesTotalSize += Files.size(file);
//                    return super.visitFile(file, attrs);
//                }
//
//                @Override
//                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//                    if (!dir.equals(path)) {
//                        dirsCount++;
//                    }
//                    return super.postVisitDirectory(dir, exc);
//                }
//            });
//
//            System.out.println("Всего папок - " + dirsCount);
//            System.out.println("Всего файлов - " + filesCount);
//            System.out.println("Общий размер - " + filesTotalSize);
//
//        } else {
//            System.out.println(path.toAbsolutePath() + " - не папка");
//        }
//
//
//    }
//}
//
//
