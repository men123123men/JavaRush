package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize =-1;
    private int maxSize =-1;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }
    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }
    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public List<Path> getFoundFiles() {
        return foundFiles;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path path = file.toRealPath();

        byte[] content = Files.readAllBytes(file); // размер файла: content.length

//        if ( Objects.nonNull(partOfName) && file.getFileName().toString().contains(partOfName)
//            || Objects.nonNull(partOfContent) && Files.lines(path).anyMatch(s->s.contains(partOfContent))
//            || maxSize != 0 && content.length<= maxSize
//            || maxSize != 0 && content.length> minSize
//                )
//            foundFiles.add(file);


        boolean minSizeOk = minSize == -1 || content.length >= minSize;
        boolean maxSizeOk = maxSize == -1 || content.length <= maxSize;
        boolean nameOk = partOfName == null || file.getFileName().toString().contains(partOfName);
        boolean contentOk = partOfContent == null || new String(content).contains(partOfContent);

        //System.out.println(content.length + " " + minSizeOk + " " + maxSizeOk + " " + nameOk + " " + contentOk + " - " + file.getFileName());

        if (minSizeOk && maxSizeOk && nameOk && contentOk) {
            foundFiles.add(file);
        }







        return FileVisitResult.CONTINUE;
    }

//    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        Path path = file.toRealPath();
//        if ((partOfName == null || file.getFileName().toString().contains(partOfName)) &&
//                (minSize == -1 || file.toFile().length() > maxSize) &&
//                (maxSize == -1 || file.toFile().length() < maxSize) &&
//                (partOfContent == null || Files.lines(path).anyMatch(s->s.contains(partOfContent))) {
//            foundFiles.add(file);
//        }
//        return FileVisitResult.CONTINUE;
//    }





}
