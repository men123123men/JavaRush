package com.javarush.task.experements.zipFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class JavenueInfo {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/Users/admin/Desktop/Если кончился инет");
        Path result = compressFile(path);


//        File file = new File("/Users/admin/Desktop/Если кончился инет");
//
//        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("/Users/admin/Desktop/archive.zip"));
//
//        doZip(file, out);
//
//        out.close();
    }

    private static Path compressFile(Path path) throws IOException {
        Path zipFile = Paths.get(path.getParent().toString(),path.getFileName().toString()+".zip");
        Files.deleteIfExists(zipFile);
        Files.createFile(zipFile);

        ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(zipFile));


//        List<File> allFiles = Files.walk(path)
//                .filter(Files::isRegularFile)
//                .map(Path::toFile)
//                .collect(Collectors.toList());
//
//        for(File file : allFiles){
//            zipOut.putNextEntry(new ZipEntry(file.getPath()));
//            new FileInputStream(file).transferTo(zipOut);
//        }

        return zipFile;

    }
//
    private static void doZip(File dir, ZipOutputStream out) throws IOException {
        for (File f : dir.listFiles())
            if (f.isDirectory())
                doZip(f, out);
            else {
                out.putNextEntry(new ZipEntry(f.getPath()));
                new FileInputStream(f).transferTo(out);
            }
    }
}
