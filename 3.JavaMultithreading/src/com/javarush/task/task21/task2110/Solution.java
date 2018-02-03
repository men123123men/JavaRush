package com.javarush.task.task21.task2110;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/*
Рефакторинг методов
*/
public class Solution {
    public static void writeZipEntriesToFile(String zipFileName, String outputFileName) {
        Charset charset = StandardCharsets.UTF_8;
        Path outputFilePath = Paths.get(outputFileName);

        try(BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset);
            ZipFile zip = new ZipFile(zipFileName)) {

            String lineSeparator = System.getProperty("line.separator");

            List<String> stringList = zip.stream()
                    .map(ZipEntry::getName)
                    .collect(Collectors.toList());

            for(String str: stringList)
                writer.write(str+lineSeparator);


//            String currentZipEntryName =null;
//            ZipEntry currentZipEnty = null;
//            Enumeration<ZipEntry> entries1  = (Enumeration<ZipEntry>) zip.entries();
//
//            while (entries1.hasMoreElements()){
//                currentZipEnty = entries1.nextElement();
//                currentZipEntryName = currentZipEnty.getName() + newLine;
//                writer.write(currentZipEntryName, 0, currentZipEntryName.length());
//            }


//            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
//                // Берем имя файла из архива и записываем его в результирующий файл
//                // Get the entry name and write it to the output file
//                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
//                writer.write(zipEntryName, 0, zipEntryName.length());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { }
}
