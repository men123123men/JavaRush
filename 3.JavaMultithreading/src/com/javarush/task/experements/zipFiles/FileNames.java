package com.javarush.task.experements.zipFiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileNames {

    public static void writeZipEntriesToFile(String zipFileName, String outputFileName) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        Path outputFilePath = Paths.get(outputFileName);
        Files.deleteIfExists(outputFilePath);
        Files.createFile(outputFilePath);

        try(BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset);
            ZipFile zip = new ZipFile(zipFileName,StandardCharsets.UTF_8)) {

            String lineSeparator = System.getProperty("line.separator");

            List<String> stringList = zip.stream()
                    .map(ZipEntry::getName)
                    .sorted()
                    .collect(Collectors.toList());

            for(String str: stringList)
                writer.write(str+lineSeparator);


            Enumeration entries = zip.entries();
            while ( entries.hasMoreElements() ) {
                // Берем имя файла из архива и записываем его в результирующий файл
                // Get the entry name and write it to the output file
                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + lineSeparator;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }

            Files.readAllLines(outputFilePath, StandardCharsets.UTF_8).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        writeZipEntriesToFile("/Users/admin/Desktop/Если кончился инет 2.zip","/Users/admin/Desktop/3 слова2.txt");

    }
}




