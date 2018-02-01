package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
Находим все файлы
*/
public class Solution {
//    public static List<String> getFileTree(String root) throws IOException {
//        File rootDir = new File(root);
//        List<String> result = new ArrayList<>();
//        Queue<File> fileTree = new PriorityQueue<>();
//
//        Collections.addAll(fileTree, rootDir.listFiles());
//
//        while (!fileTree.isEmpty()) {
//            File currentFile = fileTree.remove();
//            if(currentFile.isDirectory()){
//                Collections.addAll(fileTree, currentFile.listFiles());
//            } else {
//                result.add(currentFile.getAbsolutePath());
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) throws IOException {
        //FileSystems.getDefault().getRootDirectories().forEach(System.out::println);
//        Iterator<Path> paths = Files.newDirectoryStream(Paths.get("/")).iterator();
//        Stream.generate(paths::next)
//                //.takeWhile(p->paths.hasNext())
//                .forEach(System.out::println);
        //Stream.iterate(Paths.get("/"),paths::hasNext,))



        getFileTree("/Users/admin/Downloads/TIJ4-code").forEach(System.out::println);




    }
//    public static List<String> getFileTree(String root){
//        return fileTree(new ArrayList<>(), new File(root));
//    }
//    public static List<String> fileTree(List<String> list, File input ){
//        if (input.isFile())
//            list.add(input.getAbsolutePath());
//        else
//            for(File currentFile: input.listFiles())
//                fileTree(list,currentFile);
//        return list;
//    }

    public static List<String> getFileTree(String root){
        Collection<File> container = new CopyOnWriteArrayList<>();
        container.addAll(Arrays.asList(new File(root).listFiles()));

        List<String> result = new ArrayList<>();

        for(File currentFile: container) {
            if (currentFile.isFile())
                result.add(currentFile.getAbsolutePath());
            else
                container.addAll(Arrays.asList(currentFile.listFiles()));
        }
        return result;
    }

//    public static List<String> getFileTree(String root) throws IOException {
//        return Files.walk(Paths.get(root))
//                .filter(Files::isRegularFile)
//                .map(Path::toString)
//                .collect(Collectors.toList());
//    }


}
