package com.javarush.task.experements.zipFiles;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PackZip {

    public static File pack(String dirName) throws IOException {

        Path dir = Paths.get(dirName);

        if (Files.notExists(dir) || !Files.isDirectory(dir))
            throw new FileNotFoundException(dir + " not found");

        File zipFile = new File(dir+".zip");  // +Integer.toString(new Random().nextInt(1000))

        //if (zipFile.exists()) zipFile.delete();

        try(Stream<Path> pathStream = Files.walk(dir).filter(Files::isRegularFile);
            FileOutputStream fos   = new FileOutputStream(zipFile);
            ZipOutputStream zos    = new ZipOutputStream(fos)) {

            zos.setLevel(Deflater.BEST_SPEED);

            for(Path currentFile: pathStream.collect(Collectors.toList())){
                zos.putNextEntry(new ZipEntry(dir.relativize(currentFile).toString()));
                Files.copy(currentFile,zos);
                zos.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return zipFile;
    }

    public static void main(String[] args) throws IOException {
        String dirStr = "/Users/admin/Desktop/Если кончился инет";
        File zipFile = pack(dirStr);

        if (Desktop.isDesktopSupported())
            Desktop.getDesktop().open(zipFile);


    }

}

